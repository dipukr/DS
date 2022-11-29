import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {

	public class Node {
		public T data;
		public Node prev;
		public Node next;
		public Node(T data) {this(data,null,null);}
		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	private int count = 0;

	public void insertAtHead(T data) {
		if (empty())
			head = tail = new Node(data, null, null);
		else {
			head.prev = new Node(data, null, head);
			head = head.prev;
		}
	}

	public void insertAtTail(T data) {
		if (empty())
			head = tail = new Node(data, null, null);
		else {
			tail.next = new Node(data, tail, null);
			tail = tail.next;
		}
	}

	public void insertBefore(Node node, T next) {}
	public void insertAfter(Node node, T prev) {}

	public T deleteHead() {
		if (empty()) throw new NoSuchElementException("list is empty");
		T retval = head.data;
		if (head.next == null)
			head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
		count--;
		return retval;
	}

	public T deleteTail() {
		if (empty()) throw new NoSuchElementException("list is empty");
		T retval = tail.data;
		if (head.next == null)
			head = tail = null;
		else {
			tail = tail.prev;
			tail.next = null;
		}
		count--;
		return retval;
	}

	public void delete(Node node) {}
	public boolean contains(T elem) {}
	public int size() {return count;}
	public boolean empty() {return count == 0;}
}