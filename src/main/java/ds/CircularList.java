package ds;

public class CircularList {

	public class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;
	private int count;

	public void addHead(int data) {
		Node node = new Node(data);
		if (head == null) {
			node.next = node;
			head = tail = node;
			return;
		}
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = node;
		node.next = head;
		head = node;
	}

	public void addTail(int data) {
		if (head == null) {
			addHead(data);
			return;
		}
		Node node = new Node(data);
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = node;
		node.next = head;
	}

	public void dump() {
		if (head == null) return;
		Node curr = head;
		do {
			System.out.printf("%d->", curr.data);
			curr = curr.next;	
		} while (curr != head);
		System.out.println("null");
	}
	
	public boolean hasCycle() {
		return true;
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