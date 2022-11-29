import java.util.Stack;
import java.util.Iterator;

public class AVL<T extends Comparable<T>> implements Iterable<T> {
	
	private class Node {
		public T data;
		public int height;
		public int factor;
		public Node lhs, rhs;
		public Node(T data) {this.data = data;}
	}
	
	private Node root;
	private int nodeCount = 0;

	public int height() {
		if (root == null) return 0;
		return root.height;
	}

	public int size() {return nodeCount;}
	public boolean empty() {return size() == 0;}

	public boolean find(T data) {
		if (empty() || data == null)
			return false;
		return find(root, data);
	}

	private boolean find(Node node, T data) {
		if (node == null) return false;
		int cmp = data.compareTo(node.data);
		if (cmp < 0) return find(node.lhs, data);
		else if (cmp > 0) return find(node.rhs, data);
		else return true;
	}

	public boolean insert(T data) {
		if (data == null) return false;
		if (!find(root, data)) {
			root = insert(root, data);
			nodeCount++;
			return true;
		}
		return false;
	}

	private Node insert(Node node, T data) {
		if (node == null) 
			return new Node(data);
		int cmp = data.compareTo(node.data);
		if (cmp < 0) node.lhs = insert(node.lhs, data);
      	else node.rhs = insert(node.rhs, data);
		update(node);
		return balance(node);
	}

	private void update(Node node) {
		int lhsHeight = (node.lhs == null) ? -1 : node.lhs.height;
		int rhsHeight = (node.rhs == null) ? -1 : node.rhs.height;
		node.height = Math.max(lhsHeight, rhsHeight) + 1;
		node.factor = rhsHeight - lhsHeight;
	}

	private Node balance(Node node) {
		if (node.factor == -2) {
			if (node.lhs.factor <= 0)
        		return leftLeftCase(node);
        	return leftRightCase(node);
		} else if (node.factor == +2) {
			if (node.rhs.factor >= 0)
				return rightRightCase(node);
			return rightLeftCase(node);	
		}
		return node;
	}

	private Node leftLeftCase(Node node) {
		return rightRotation(node);
	}

	private Node leftRightCase(Node node) {
		node.lhs = leftRotation(node.lhs);
		return leftLeftCase(node);
	}

	private Node rightRightCase(Node node) {
		return leftRotation(node);
	}

	private Node rightLeftCase(Node node) {
		node.rhs = rightRotation(node.rhs);
		return rightRightCase(node);
	}

	private Node leftRotation(Node node) {
		Node newParent = node.rhs;
		node.rhs = newParent.lhs;
		newParent.lhs = node;
		update(node);
		update(newParent);
		return newParent;
	}

	private Node rightRotation(Node node) {
		Node newParent = node.lhs;
		node.lhs = newParent.rhs;
		newParent.rhs = node;
		update(node);
		update(newParent);
		return newParent;
	}

	public boolean delete(T data) {
		if (data == null) return false;
		if (find(root, data)) {
			root = delete(root, data);
			nodeCount--;
			return true;
		}
		return false;
	}

	private Node delete(Node node, T data) {
		if (node == null) return null;
		int cmp = data.compareTo(node.data);
		if (cmp < 0)
			node.lhs = delete(node.lhs, data);
		else if (cmp > 0)
			node.rhs = delete(node.rhs, data);
		else {
			if (node.lhs == null)
        		return node.rhs;
			else if (node.rhs == null)
				return node.lhs;
			else {
				if (node.lhs.height > node.rhs.height) {
					T successorValue = findMax(node.lhs);
					node.data = successorValue;
					node.lhs = delete(node.lhs, successorValue);
				} else {
					T successorValue = findMin(node.rhs);
					node.data = successorValue;
					node.rhs = delete(node.rhs, successorValue);
				}
			}
		}
		update(node);
		return balance(node);
	}

	private T findMin(Node node) {
		while (node.lhs != null)
			node = node.lhs;
		return node.data;
	}

	private T findMax(Node node) {
		while (node.rhs != null)
			node = node.rhs;
		return node.data;
	}

	public Iterator<T> iterator() {
		int expectedNodeCount = nodeCount;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		return new Iterator<T>() {
			Node trav = root;

			public boolean hasNext() {
				return root != null && !stack.isEmpty();
			}

			public T next() {
				while (trav != null && trav.lhs != null) {
					stack.push(trav.lhs);
					trav = trav.lhs;
				}
				Node node = stack.pop();
				if (node.rhs != null) {
					stack.push(node.rhs);
					trav = node.rhs;
				}
				return node.data;
			}
		};
	}
  	
  	public boolean validate(Node node) {
    	if (node == null) return true;
		boolean valid = true;
		if (node.lhs != null) valid = valid && node.lhs.data.compareTo(node.data) < 0;
		if (node.rhs != null) valid = valid && node.rhs.data.compareTo(node.data) > 0;
		return valid && validate(node.lhs) && validate(node.rhs);
	}

	public static void main(String[] args) throws Exception {
		var avl = new AVL<Integer>();
		for (int i = 0; i < 1000000; i++)
			avl.insert(i);
		System.out.println(avl.height());
	}
}