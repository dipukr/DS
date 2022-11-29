public class SinglyList<T> {

	private class Node {
		public T data;
		public Node next;
		public Node(T data) {
			this.data = data;
		}
	}

	private Node head = null;
	private int nodeCount = 0;

	public int size() {return nodeCount;}
	public boolean empty() {return size() == 0;}

	public void pushFront(T data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		nodeCount++;
	}

	public void pushBack(T data) {
		Node node = new Node(data);
		if (empty()) {
			head = node;
			return;
		}
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
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
		Node curr = head, prev = null;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		T retval = prev.next.data;
		prev.next = null;
		nodeCount--;
		return retval;
	}

	public void insertAfter(Node after, T data) {
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
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		return curr.data;
	}

	public void reverse() {
		Node curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void reverseR() {
		reverseR(head);
	}

	public void reverseR(Node node) {
		if (node.next == null) {
			head = node;
			return;
		}
		reverseR(node.next);
		Node tmp = node.next;
		tmp.next = node;
		//node.next = null;
	}

	public void print() {
		for (var curr = head; curr != null; curr = curr.next)
			System.out.print(curr.data+"->");
		System.out.println("null");
	}

	// private void print2(Node node) {
	// 	if (node != null) {
	// 		System.out.print(node.data+"\t");
	// 		printRec2(node.next);
	// 	}
	// }

	// public void print2() {
	// 	print2(head);
	// 	System.out.println();

	// }

	// private void print3(Node node) {
	// 	if (node != null) {
	// 		print3(node.next);
	// 		System.out.print(node.data+"\t");
	// 	}
	// }

	// public void print3() {
	// 	print3(head);
	// 	System.out.println();
	// }
}
