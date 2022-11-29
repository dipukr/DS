public class LinkedList<T> {

	private static class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int nodeCount = 0;

	public int size() {return nodeCount;}
	public boolean empty() {return nodeCount == 0;}

	public void pushFront(T data) {
		Node node = new Node(data);
		if (empty()) {
			head = tail = node;
			nodeCount++;
			return;
		}
		node.next = head;
		head = node;
		nodeCount++;
	}

	public void pushBack(T data) {
		Node node = new Node(data);
		if (empty()) {
			head = tail = node;
			nodeCount++;
			return;
		}
		tail.next = node;
		tail = node;
		nodeCount++;
	}

	public T popFront() {
		if (empty()) throw new Error("list underflow");
		T retval = head.data;
		head = head.next;
		nodeCount--;
		return retval;
	}

	public T popBack() {
		if (empty()) throw new Error("list underflow");
		if (head.next == null)
			return popFront();
		Node node = head, save = null;
		while (node.next != null) {
			save = node;
			node = node.next;
		}
		T retval = save.next.data;
		save.next = null;
		nodeCount--;
		return retval;

	}

	public void insert(Node after, T data) {
		Node node = new Node(data);
		node.next = after.next;
		after.next = node;
		nodeCount++;
	}

	public void delete(Node node) {

	}

	public T front() {
		if (empty()) throw new Error("List empty");
		return head.data;
	}

	public T back() {
		if (empty()) throw new Error("List empty");
		Node node = head;
		while (node.next != null)
			node = node.next;
		return node.data;
	}

	public void print1() {
		for (var iter = head; iter != null; iter = iter.next) {
			System.out.print(iter.data+"\t");
		}
		System.out.println();
	}

	private void printRec1(Node node) {
		if (node != null) {
			printRec1(node.next);
			System.out.print(node.data+"\t");
		}
	}

	private void printRec2(Node node) {
		if (node != null) {
			System.out.print(node.data+"\t");
			printRec2(node.next);
		}
	}

	public void print2() {
		printRec1(head);
		System.out.println();

	}

	public void print3() {
		printRec2(head);
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		var list = new List1<Integer>();
		for(int i=1;i<10;i++)
			list.pushFront(100*i);
		list.print1();
		list.print2();
		list.print3();
	}
}
