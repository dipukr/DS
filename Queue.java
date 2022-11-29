import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

	private class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int count = 0;

	public int size() {return count;}
	public boolean empty() {return size() == 0;}
	
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
		if (empty()) throw new Error("queue underflow");
		T retval = head.data;
		head = head.next;
		count--;
		return retval;
	}

	public T front() {
		if (empty()) throw new Error("queue underflow");
		return head.data;
	}

	public Iterator<T> iterator() {
		return new IteratorImpl();
	}

	public String toString() {
		var buf = new StringBuffer("[");
		int i = 0;
		for (T elem: this) {
			if (i++ > 0)
				buf.append(", ");
			buf.append(elem);
		}
		buf.append(']');
		return buf.toString();
	}

	private class IteratorImpl implements Iterator<T> {
		private Node curr = head;

		public boolean hasNext() {
			return curr != null;
		}

		public T next() {
			if (!hasNext()) throw new Error("queue empty");
			T retval = curr.data;
			curr = curr.next;
			return retval;
		}
	}
}