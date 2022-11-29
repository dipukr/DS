public class Stack3<T> {

	private Queue<T> q1;
	private Queue<T> q2;
	private int count;

	public Stack3() {
		this.q1 = new Queue<T>();
		this.q2 = new Queue<T>();
		this.count = 0;
	}

	public void push(T elem) {
		q1.enqueue(elem);
		count++;
	}

	public T pop() {
		if (q1.empty()) throw new Error("stack overflow");
		count--;
		while (q1.size() != 1)
			q2.enqueue(q1.dequeue());
		T retval = q1.dequeue();
		Queue<T> temp = q1;
		q1 = q2;
		q2 = q1;
		return retval;
	}

	public T top() {
		return what();
	}

	public int size() {
		return count;
	}
}