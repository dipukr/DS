package ds;

public class QueueStack {

	private Stack s1 = new Stack();
	private Stack s2 = new Stack();

	public void enqueue(int elem) {
		s1.push(elem);
	}

	public int dequeue() {
		if (empty()) Error.fatal("Queue underflow.");
		if (s2.empty()) {
			while (s1.notEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}

	public boolean empty() {
		return s1.empty() && s2.empty();
	}
	
	public boolean notEmpty() {
		return !empty();
	}
}