package main;

public class QueueStack {

	private Stack a = new Stack();
	private Stack b = new Stack();

	public void enqueue(int elem) {
		a.push(elem);
	}

	public int dequeue() {
		if (empty()) Error.error("Queue underflow.");
		if (b.empty()) {
			while (a.notEmpty())
				b.push(a.pop());
		}
		return b.pop();
	}

	public boolean empty() {
		return a.empty() && b.empty();
	}
}