package main;

import java.util.StringJoiner;

public class Vector {

	private double[] data;

	public Vector(int size) {
		this.data = new double[size];
	}

	public Vector(double... data) {
		this.data = new double[data.length];
		for (int i = 0; i < data.length; i++)
			this.data[i] = data[i];
	}

	public void scale(double factor) {
		for (int i = 0; i < size(); i++)
			data[i] = factor * data[i];
	}

	public void add(Vector that) {
		verifyDim(this, that);
		if (this.size() != that.size()) Error.fatal("dim incompatible");
		for (int i = 0; i < size(); i++)
			data[i] += that.data[i];
	}

	public void subtract(Vector that) {
		verifyDim(this, that);
		for (int i = 0; i < size(); i++)
			data[i] -= that.data[i];
	}

	public void multiply(Vector that) {
		verifyDim(this, that);
		for (int i = 0; i < size(); i++)
			data[i] *= that.data[i];
	}

	public double dot(Vector that) {
		verifyDim(this, that);
		double result = 0.0;
		for (int i = 0; i < size(); i++)
			result += this.data[i] * that.data[i];
		return result;
	}

	public static Vector times(Vector vector, double factor) {
		Vector temp = new Vector(vector.size());
		for (int i = 0; i < vector.size(); i++)
			temp.data[i] = factor * vector.data[i];
		return temp;
	}

	public static Vector add(Vector a, Vector b) {
		verifyDim(a, b);
		Vector temp = new Vector(a.size());
		for (int i = 0; i < a.size(); i++)
			temp.data[i] = a.data[i] + b.data[i];
		return temp;
	}
	
	public static void verifyDim(Vector a, Vector b) {
		if (a.size() != b.size())
			Error.fatal("Dimension unmatched.");
	}

	public static Vector subtract(Vector a, Vector b) {
		verifyDim(a, b);
		Vector temp = new Vector(a.size());
		for (int i = 0; i < a.size(); i++)
			temp.data[i] = a.data[i] - b.data[i];
		return temp;
	}

	public static Vector multiply(Vector a, Vector b) {
		verifyDim(a, b);
		Vector temp = new Vector(a.size());
		for (int i = 0; i < a.size(); i++)
			temp.data[i] = a.data[i] * b.data[i];
		return temp;
	}

	public static double dot(Vector a, Vector b) {
		verifyDim(a, b);
		double result = 0.0;
		for (int i = 0; i < a.size(); i++)
			result += a.data[i] * b.data[i];
		return result;
	}
	
	public Vector direction() {
		if (magnitude() == 0.0)
			Error.fatal("Zero vector has no direction.");
		return Vector.times(this, 1.0 / magnitude());
	}

	public double distanceTo(Vector that) {
		verifyDim(this, that);
		return Vector.subtract(this, that).magnitude();
	}

	public double magnitude() {
		return Math.sqrt(dot(this));
	}
	
	public double cartesian(int i) {
		return data[i];
	}
	
	public int size() {
		return data.length;
	}

	@Override
	public String toString() {
		var s = new StringJoiner(",", "[", "]");
		for (var elem: data)
			s.add(String.valueOf(elem));
		return s.toString();
	}
}
