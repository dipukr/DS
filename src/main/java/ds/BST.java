package ds;

public class BST {
	
	public class Node {
		public int data;
		public Node left;
		public Node right;
		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;
	
//	public void insert(int data) {
//		if (!search(data)) {
//			root = insert(root, data);
//		}
//	}
//
//	public void insert(int data) {
//		if (search(data)) return;
//		Node node = new Node(data);
//		if (empty()) {
//			root = node;
//			return;
//		}
//		Node curr = root, prev = null;
//		while (curr != null) {
//			prev = curr;
//			if (data < curr.data) curr = curr.left;
//			else if (data > curr.data) curr = curr.right;
//		}
//		if (data < prev.data) prev.left = node;
//		else prev.right = node;
//	}
	
	public boolean search(int data) {
		Node node = root;
		while (node != null) {
			if (data < node.data) node = node.left;
			else if (data > node.data) node = node.right;
			else return true;
		}
		return false;
	}
	
	public int findMin() {
		if (empty()) Error.fatal("Tree is empty.");
		Node node = root;
		while (node.left != null)
			node = node.left;
		return node.data;
	}
	
	public int findMax() {
		if (empty()) Error.fatal("Tree is empty.");
		Node node = root;
		while (node.right != null)
			node = node.right;
		return node.data;
	}

	public void deleteMin() {

	}

	public void deleteMax() {
		
	}

//	public void delete(int data) {
//		if (search(data)) {
//			root = delete(root, data);
//		}
//	}
//
//	public void merge(BinarySearchTree tree) {
//		this.root = merge(this.root, tree.root);
//	}

	public Node merge(Node t1, Node t2) {
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		t1.data += t2.data;
		t1.left = merge(t1.left, t2.left);
		t1.right = merge(t1.right, t2.right);
		return t1;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.printf("%d\t", root.data);
			inOrder(root.right);
		}
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void preOrder(Node root) {
		if (root != null) {
			System.out.printf("%d\t", root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}

	public void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.printf("%d\t", root.data);
		}
	}

	public int size() {
		return size(root);
	}

	public int size(Node root) {
		if (root == null) return 0;
		int leftSize = size(root.left);
		int rightSize = size(root.right);
		return leftSize + rightSize + 1;
	}
	
	public int height() {
		return height(root);
	}
	
	public int height(Node root) {
		if (root == null) return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean empty() {
		return size() == 0;
	}
}
