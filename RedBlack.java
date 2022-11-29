public class RedBlack<T extends Comparable<T>> {

	private static enum Color {RED, BLACK};

	private static class Node {
		T data;
		Node left;
		Node right;
		Node parent;
		Color color;
		public Node(T data)
			{this.data = data;}
	}

	private Node root = null;
	private int nodeCount = 0;

	public int size() {return nodeCount;}
	public int height() {}
	public boolean empty() {return nodeCount == 0;}

	public boolean insert(T data) {
		if (data == null)
			throw new IllegalArgumentException();
		if (root == null) {
			root = new Node(data, null);
			insertFixup(root);
			nodeCount++;
			return true;
		}
		Node node = root;
		while (node != null) {
			int cmp = data.compareTo(node.data);
			if (cmp < 0) {
				if (node.left == null) {
					node.left = new Node(data, node);
					insertFixup(node.left);
					nodeCount++;
					return true;
				}
				node = node.left;
			} else if (cmp > 0) {
				if (node.right == null) {
					node.right = new Node(data, node);
					insertFixup(node.right);
					nodeCount++;
					return true;
				}
				node = node.right;
			} else return false;
		}
	}

	private void insertFixup(Node node) {
		
	}

	public boolean find(T data) {
		Node node = root;
		if (node == null || data == null)
			return false;
		while (node != null) {
			int cmp = data.compareTo(node.data);
			if (cmp < 0) node = node.left;
			else if (cmp > 0) node = node.right;
			else return true;	
		}
		return false;
	}

	private Node leftRotate(Node x) {}
	private Node rightRotate(Node x) {}
}