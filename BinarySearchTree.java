public class BST2<T extends Comparable<T>> {
	
	private class Node {
		public T data;
		public Node left;
		public Node right;
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root = null;

	public int size() {return size(root);}
	public int height() {return height(root);}
	public boolean empty() {return root == null;}

	public boolean insert(T data) {
		Node node = new Node(data);
		if (empty()) {
			root = node;
			return true;
		}
		Node curr = root, prev = null;
		while (curr != null) {
			prev = curr;
			int cmp = data.compareTo(curr.data);
			if (cmp < 0) curr = curr.left;
			else if (cmp > 0) curr = curr.right;
			else return false;
		}
		if (data.compareTo(prev.data) < 0)
			prev.left = node;
		else prev.right = node;
		return true;	
	}

	public boolean delete(T data) {
		return true;
	}
	
	public boolean find(T data) {
		Node node = root;
		while (node != null) {
			int cmp = data.compareTo(node.data);
			if (cmp < 0) node = node.left;
			else if (cmp > 0) node = node.right;
			else return true;
		}
		return false;
	}

	public T findMin() {
		if (empty()) throw new Error("Tree empty");
		return findMin(root).data;
	}

	public T findMax() {
		if (empty()) throw new Error("Tree empty");
		return findMax(root).data;
	}

	public void deleteMin() {

	}

	public void deleteMax() {
		
	}

	private Node findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}
	
	private Node findMax(Node node) {
		while (node.right != null)
			node = node.right;
		return node;
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		else return 1 + Math.max(height(node.left), height(node.right));
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		else return 1 + size(node.left) + size(node.right);
	}

	public static void main(String[] args) {
		var bst = new BST2<Integer>();
		var rand = new java.util.Random();
		for(int i=0;i<1024;i++)
			bst.insert(i);
		System.out.println(bst.size());
		System.out.println(bst.height());
	}
}