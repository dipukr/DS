public class CircularList<T> {

	private class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
		}
	}

	private Node head = null;

	public void insertAtHead(T data) {
		Node node = new Node(data);
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

	public void insertAtTail(T data) {
		if (head == null) {
			insertAtHead(data);
			return;
		}
		Node node = new Node(data);
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = node;
		node.next = head;
	}

	public T deleteHead() {}
	public T deleteTail() {}

	public void insertAfter(Node node, T data) {}
	public void deleteAfter(Node node, T data) {}
	
	public void delete(Node node) {}
	public void delete(T data) {}

	public void print() {
		if (head == null) return;
		Node curr = head;
		do {
			System.out.print(curr.data+"->");
			curr = curr.next;	
		} while (curr != head);
		System.out.println("null");
	}

	public int size() {return 0;}
	public boolean empty() {return head == null;}

	public static void main(String[] args) throws Exception {
		var cl = new CircularList<Integer>();
		cl.insertAtTail(100);
		cl.insertAtTail(200);
		cl.insertAtTail(300);
		cl.insertAtHead(400);
		cl.print();
	}
}