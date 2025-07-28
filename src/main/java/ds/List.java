package ds;

public class List {
	
	public class Node {
		public Object data;
		public Node next;
		
		public Node(Object data) {
			this(data, null);
		}
		
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	private Node head;
	private Node tail;
	
	public void addHead(Object data) {
		if (empty()) {
			head = tail = new Node(data);
		} else {
			head = new Node(data, head);
		}
	}
	
	public void addTail(Object data) {
		if (empty()) {
			head = tail = new Node(data);
		} else {
			Node node = new Node(data);
			tail.next = node;
			tail = node;
		}
	}
	
	public void deleteHead() {
		if (empty()) Error.fatal("List is empty.");
		head = head.next;
		if (head == null)
			tail = null;
	}
	
	public void deleteTail() {
		if (empty()) Error.fatal("List is empty.");
		if (head.next == null) {
			head = tail = null;
		} else {
			Node curr = head;
			while (curr.next.next != null)
				curr = curr.next;
			curr.next = null;
			tail = curr;
		}
	}
	
	public void reverse() {
		Node prev = null, curr = head, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		tail = head;
		head = prev;
	}
	
	public void dump() {
		if (!empty()) return;
		for (var curr = head; curr != null; curr = curr.next)
			System.out.printf("%s->", curr.data);
		System.out.println("null");
	}
	
	public boolean empty() {
		return head == null && tail == null;
	}
	
	public int size() {
		int nodeCount = 0;
		for (Node curr = head; curr != null; curr = curr.next)
			nodeCount++;
		return nodeCount;
	}
}
