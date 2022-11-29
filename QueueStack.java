public class Queue3<T> {

	private Stack<T> s1;
	private Stack<T> s2;

	public Queue3() {
		this.s1 = new Stack<T>();
		this.s2 = new Stack<T>();
	}

	public void enqueue(T elem) {
		s1.push(elem);
	}

	public T dequeue() {
		if (s1.empty() && s2.empty()) throw new Error("queue underflow");
		if (s2.empty()) {
			while (!s1.empty())
				s2.push(s1.pop());
		}
		int val = s2.pop();
		return val;
	}

	public boolean empty() {
		return s1.empty() && s2.empty();
	}
}