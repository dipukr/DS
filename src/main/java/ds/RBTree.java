package ds;

public class RBTree {

	private static final int RED = 0;
	private static final int BLACK = 1;

	public class Node {
		public int data;
		public int color;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int data) {
			this.data = data;
		}
	}

	private final Node NIL = new Node(0);
	private Node root = null;
	private int nodeCount = 0;

	public void flipColor(Node node) {
		node.color = node.color == RED ? BLACK : RED;
	}
	
	
	public boolean search(int key) {
		Node node = root;
		while (node != null) {
			if (key < node.data) node = node.left;
			else if (key > node.data) node = node.right;
			else return true;
		}
		return false;
	}
	
	public void insert(int data) {
		Node node = new Node(data);
		
	}
	
	public void leftRotate(Node x) {
		Node 
	}

	public int size() {
		return nodeCount;
	}

	public boolean empty() {
		return size() == 0;
	}
}
