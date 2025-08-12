package main;

public class Stack {
	
	public class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head = null;
	private int nodeCount = 0;

	public void push(int elem) {
		Node node = new Node(elem);
		node.next = head;
		head = node;
		nodeCount++;
	}

	public int pop() {
		if (empty()) Error.fatal("Stack underflow.");
		int retval = head.data;
		head = head.next;
		nodeCount--;
		return retval;
	}

	public int top() {
		if (empty()) Error.fatal("Stack underflow.");
		return head.data;
	}
	
	public int size() {
		return nodeCount;
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public boolean notEmpty() {
		return !empty();
	}
}