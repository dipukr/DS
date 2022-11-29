public class Vector {

	private double[] data;
	private int n;

	public Vector(int size) {
		this.n = size;
		this.data = new double[size];
	}

	public Vector(double... data) {
		this.n = data.length;
		this.data = new double[n];
		for (int i = 0; i < n; i++)
			this.data[i] = data[i];
	}

	public void scale(double factor) {
		for (int i = 0; i < n; i++)
			data[i] = factor * data[i];
	}

	public void add(Vector that) {
		if (this.n != that.n) throw new Error("dim incompatible");
		for (int i = 0; i < n; i++)
			data[i] += that.data[i];
	}

	public void subtract(Vector that) {
		if (this.n != that.n) throw new Error("dim incompatible");
		for (int i = 0; i < n; i++)
			data[i] -= that.data[i];
	}

	public void multiply(Vector that) {
		if (this.n != that.n) throw new Error("dim incompatible");
		for (int i = 0; i < n; i++)
			data[i] *= that.data[i];
	}

	public double dot(Vector that) {
		if (this.n != that.n) throw new Error("dimensions incompatible");
		double result = 0.0;
		for (int i = 0; i < n; i++)
			result += this.data[i] * that.data[i];
		return result;
	}

	public static Vector times(Vector vec, double factor) {
		Vector tmp = new Vector(vec.n);
		for (int i = 0; i < vec.n; i++)
			tmp.data[i] = factor * vec.data[i];
		return tmp;
	}

	public static Vector add(Vector a, Vector b) {
		if (a.n != b.n) throw new Error("dimensions incompatible");
		Vector tmp = new Vector(a.n);
		for (int i = 0; i < a.n; i++)
			tmp.data[i] = a.data[i] + b.data[i];
		return tmp;
	}

	public static Vector subtract(Vector a, Vector b) {
		if (a.n != b.n) throw new Error("dimensions incompatible");
		Vector tmp = new Vector(a.n);
		for (int i = 0; i < a.n; i++)
			tmp.data[i] = a.data[i] - b.data[i];
		return tmp;
	}

	public static Vector multiply(Vector a, Vector b) {
		if (a.n != b.n) throw new Error("dimensions incompatible");
		Vector tmp = new Vector(a.n);
		for (int i = 0; i < a.n; i++)
			tmp.data[i] = a.data[i] * b.data[i];
		return tmp;
	}

	public static double dot(Vector a, Vector b) {
		if (a.n != b.n) throw new Error("dimensions incompatible");
		double result = 0.0;
		for (int i = 0; i < a.n; i++)
			result += a.data[i] * b.data[i];
		return result;
	}
	
	public Vector direction() {
		if (magnitude() == 0.0) throw new Error("zero vector has not direction");
		return Vector.times(this, 1.0 / magnitude());
	}

	public double distanceTo(Vector that) {
		if (this.n != that.n) throw new Error("dimensions incompatible");
		return Vector.subtract(this, that).magnitude();
	}

	public double magnitude() {return Math.sqrt(dot(this));}
	public double cartesian(int i) {return data[i];}
	public int size() {return n;}

	public String toString() {
		var s = new StringJoiner(",", "[", "]");
		for (var elem: data)
			s.add(String.valueOf(elem));
		return s.toString();
	}

	public static void main(String[] args) throws Exception {
		var v = new Vector(10,20,30,40,50);
		System.out.println(v);
	}
}
