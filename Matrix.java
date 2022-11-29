public class Matrix {
	
	private double[][] data;
	private int rows;
	private int cols;

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.data = new double[rows][cols];
	}

	public void init(double val) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] = val;
	}

	public void randomize() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] = Math.random();
	}

	public void scale(double factor) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] *= factor;
	}

	public void add(Matrix that) {
		if (rows != that.rows || cols != that.cols)
			throw new Error("Matrix.add: incompatible shape");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] += that.data[i][j];
	}

	public void sub(Matrix that) {
		if (rows != that.rows || cols != that.cols)
			throw new Error("Matrix.sub: incompatible shape");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] -= that.data[i][j];
	}

	public void mul(Matrix that) {
		if (rows != that.rows || cols != that.cols)
			throw new Error("Matrix.mul: incompatible shape");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] *= that.data[i][j];
	}

	public void dot(Matrix that) {
		Matrix r = new Matrix(rows, that.cols);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < that.cols; j++)
				for (int k = 0; k < cols; k++)
					r.data[i][j] += data[i][k]*that.data[k][j];
	}

	public static Matrix add(Matrix m, Matrix n) {
		if (m.rows != n.rows || m.cols != n.cols)
			throw new Error("Matrix.add: incompatible shape");
		Matrix r = new Matrix(m.rows, m.cols);
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < m.cols; j++)
				r.data[i][j] = m.data[i][j] + n.data[i][j];
		return r;
	}

	public static Matrix sub(Matrix m, Matrix n) {
		if (m.rows != n.rows || m.cols != n.cols)
			throw new Error("Matrix.sub: incompatible shape");
		Matrix r = new Matrix(m.rows, m.cols);
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < m.cols; j++)
				r.data[i][j] = m.data[i][j] - n.data[i][j];
		return r;
	}

	public static Matrix mul(Matrix m, Matrix n) {
		if (m.rows != n.rows || m.cols != n.cols)
			throw new Error("Matrix.mul: incompatible shape");
		Matrix r = new Matrix(m.rows, n.cols);
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < m.cols; j++)
				r.data[i][j] = m.data[i][j] * n.data[i][j];
		return r;
	}

	public static Matrix T(Matrix m) {
		Matrix n = new Matrix(m.cols, m.rows);
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < m.cols; j++)
				n.data[j][i] = m.data[i][j];
		return n;
	}

	public static Matrix dot(Matrix m, Matrix n) {
		if (m.cols != n.rows) throw new Error("Matrix.dot: shape incompatible");
		Matrix r = new Matrix(m.rows, n.cols);
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < n.cols; j++)
				for (int k = 0; k < m.cols; k++)
					r.data[i][j] += m.data[i][k]*n.data[k][j];
		return r;
	}

	public Matrix copy() {
		Matrix tmp = new Matrix(rows, cols);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				tmp.data[i][j] = data[i][j];
		return tmp;
	}

	public static Matrix of(Vector vec) {
		
	}

	// public Vector toVector() {
	// 	int n = rows*cols;
	// 	Vector ret = new Vector(n);
	// 	for (int i = 0; i < rows; i++)
	// 		for (int j = 0; j < cols; j++)
	// 			ret.data[rows*j+i] = data[i][j];
	// 	return ret;
	// }

	public String shape() {return "("+rows+", "+cols+")";}

	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			s += "[";
			for (int j = 0; j < cols; j++) {
				if (j > 0) s += ", ";
				s += data[i][j];
			}
			s += "]\n";
		}
		return s;
	}

	public static Matrix of(int r, int c) {
		Matrix mat = new Matrix(r, c);
		return mat;
	}

	public static void main(String[] args) {
		Matrix m1 = Matrix.of(3, 1);
		Matrix m2 = Matrix.of(1, 3);
		m1.init(1);
		m2.init(1);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(Matrix.dot(m1,m2));
	}
}
