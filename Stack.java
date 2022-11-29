import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	
	private class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head = null;
	private int nodeCount = 0;

	public int size() {return nodeCount;}
	public boolean empty() {return size() == 0;}

	public void push(T elem) {
		Node node = new Node(elem);
		node.next = head;
		head = node;
		nodeCount++;
	}

	public T pop() {
		if (empty()) throw new Error("stack underflow");
		T retval = head.data;
		head = head.next;
		nodeCount--;
		return retval;
	}

	public T top() {
		if (empty()) throw new Error("stack underflow");
		return head.data;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (T elem: this)
			s.append(elem + " ");
		return s.toString();
	}

	private class ListIterator implements Iterator<T> {
		private Node curr = head;

		public boolean hasNext() {
			return curr != null;
		}

		public T next() {
			if (!hasNext()) throw new Error("no such element");
			T data = curr.data;
			curr = curr.next;
			return data;
		}
	}
}