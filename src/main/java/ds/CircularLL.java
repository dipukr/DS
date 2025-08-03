package ds;

public class CircularLL {
	
	public class Node {
		public Object data;
		public Node next;
		public Node(Object data) {
			this.data = data;
		}
	}

	private Node head = null;
	
	public void addTail(Object data) {
		Node node = new Node(data);
		if (empty()) {
			head = node;
			head.next = head;
		} else {
			
		}
		
	}
	
	public int size() {
		if (empty()) return 0;
		int count = 1;
		Node node = head;
		while (node.next != head) {
			count += 1;
			node = node.next;
		}	
		return count;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	

	
	public static void main(final String[] args) {
		var list = new CircularLL();
		
		System.out.println(list.size());
	}

}
