package main;

public class CircularList {

	public class Node {
		public Object data;
		public Node next;
		public Node(Object data) {
			this.data = data;
		}
	}

	private Node head = null;
	private int count = 0;

	public void addHead(Object elem) {
		Node node = new Node(elem);
		if (head == null) {
			node.next = node;
			head = node;
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

	public void draw() {
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
}