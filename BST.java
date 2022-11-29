public class BST<T extends Comparable<T>> {
	
	private static class Node {
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
		if (!find(data)) {
			root = insert(root, data);
			return true;
		}
		return false;
	}
	
	public boolean delete(T data) {
		if (find(data)) {
			root = delete(root, data);
			return true;
		}
		return false;
	}
	
	public boolean find(T data) {
		return find(root, data);
	}

	public T findMin() {
		if (empty()) throw new Error("Tree empty");
		return findMin(root).data;
	}
	
	public T findMax() {
		if (empty()) throw new Error("Tree empty");
		return findMax(root);
	}

	public void deleteMin() {

	}

	public void deleteMax() {
		
	}

	public void inorder() {inorder(root);}
	public void preorder() {preorder(root);}
	public void postorder() {postorder(root);}

	public void merge(BST tree) {
		this.root = merge(this.root, tree.root);
	}

	private Node merge(Node t1, Node t2) {
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		t1.data += t2.data;
		t1.left = merge(t1.left, t2.left);
		t1.right = merge(t1.right, t2.right);
	}
	
	private Node insert(Node node, T data) {
		if (node == null)
			return new Node(data);
		int cmp = data.compareTo(node.data);
		if (cmp < 0) node.left = insert(node.left, data);
		if (cmp > 0) node.right = insert(node.right, data);
		return node;
	}

	private Node delete(Node node, T data) {
		int cmp = data.compareTo(node.data);
		if (cmp < 0) node.left = delete(node.left, data);
		else if (cmp > 0) node.right = delete(node.right, data);
		else {
			if (node.left == null && node.right == null) {
				node.data = null;
				node = null;
			} else if (node.left == null) {
				node.data = null;
				node = node.right;
			} else if (node.right == null) {
				node.data = null;
				node = node.left;
			} else {
				Node temp = findMin(node);
				
			}
		}
		return node;
	}

	private boolean find(Node node, T data) {
		if (node == null) return false;
		int cmp = data.compareTo(node.data);
		if (cmp < 0) return find(node.left, data);
		else if (cmp > 0) return find(node.right, data);
		else return true;
	}

	private Node findMin(Node node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.data;
		return findMin(node.left);
	}

	private Node findMax(Node node) {
		if (node == null)
			return null;
		if (node.right == null)
			return node.data;
		return findMax(node.right);	
	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			print(node.data);
			inorder(node.right);
		}
	}

	private void preorder(Node node) {
		if (node != null) {
			print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	private void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			print(node.data);
		}
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
}