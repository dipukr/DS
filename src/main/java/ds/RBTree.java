package ds;

public class RBTree {

	private static final int RED = 1;
	private static final int BLACK = 2;

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

	private Node root = null;
	private int nodeCount = 0;

	public void flipColor(Node node) {
		node.color = node.color == RED ? BLACK : RED;
	}
	
	
	public boolean contains(int key) {
		if (getNode(key) == null) return false;
		else return true;
	}

	public Node getNode(int key) {
		Node node = root;
		while (node != null) {
			if (key < node.data) node = node.left;
			else if (key > node.data) node = node.right;
			else return node;
		}
		return null;
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
