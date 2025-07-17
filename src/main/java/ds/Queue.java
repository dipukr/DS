package ds;

public class Queue<T> {

	public class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int count = 0;

	public void enqueue(T elem) {
		Node node = new Node(elem);
		if (empty())
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}
		count++;
	}
	
	public T dequeue() {
		if (empty()) Error.fatal("Queue underflow.");
		T retval = head.data;
		head = head.next;
		count--;
		return retval;
	}

	public T front() {
		if (empty()) Error.fatal("Queue underflow.");
		return head.data;
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