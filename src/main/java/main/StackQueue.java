package main;

public class StackQueue {

	private Queue q1 = new Queue();
	private Queue q2 = new Queue();
	private int count = 0;

	public void push(int elem) {
		q2.enqueue(elem);
		count++;
		while (!q1.empty())
			q2.enqueue(q1.dequeue());
		Queue tmp = q1;
		q1 = q2;
		q2 = tmp;
	}

	public Object pop() {
		count--;
		return q1.dequeue();
	}

	public Object top() {
		return q1.front();
	}

	public int size() {
		return count;
	}

	public boolean empty() {
		return size() == 0;
	}
	
	public boolean notEmpty() {
		return !empty();
	}
}