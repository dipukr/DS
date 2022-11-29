public class Stack2<T> {

	private T[] data;
	private int sp;

	public Stack2(int size) {
		this.data = (T[]) new Object[size];
		this.sp = -1;
	}

	public void push(T elem) {
		if (++sp == data.length) throw new Error("stack overflow");
		data[sp] = elem;
	}

	public T pop() {
		if (empty()) throw new Error("stack underflow");
		return data[sp--];
	}

	public T top() {
		if (empty()) throw new Error("stack underflow");
		return data[sp];
	}

	public int size() {return sp + 1;}
	public boolean empty() {return sp == -1;}

	public static void main(String[] args) {
		var s = new Stack2<String>(10);
		s.push("Rakesh");
		s.push("Kumar");
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}
}