package ds;

public class AvlTree {
	
	public class Node {
		public double data;
		public int height;
		public int factor;
		public Node lhs, rhs;
		public Node(double data) {
			this.data = data;
		}
	}
	
	private Node root;
	private int nodeCount = 0;

	public int height() {
		if (root == null) return 0;
		return root.height;
	}

	public int size() {
		return nodeCount;
	}
	
	public boolean empty() {
		return size() == 0;
	}

	public boolean find(double data) {
		return find(root, data);
	}

	public boolean find(Node node, double data) {
		if (node == null) return false;
		if (data < node.data) return find(node.lhs, data);
		else if (data > node.data) return find(node.rhs, data);
		else return true;
	}

	public boolean insert(double data) {
		if (!find(root, data)) {
			root = insert(root, data);
			nodeCount++;
			return true;
		}
		return false;
	}

	public Node insert(Node node, double data) {
		if (node == null) 
			return new Node(data);
		if (data < node.data) node.lhs = insert(node.lhs, data);
      	else node.rhs = insert(node.rhs, data);
		update(node);
		return balance(node);
	}

	public void update(Node node) {
		int lhsHeight = (node.lhs == null) ? -1 : node.lhs.height;
		int rhsHeight = (node.rhs == null) ? -1 : node.rhs.height;
		node.height = Math.max(lhsHeight, rhsHeight) + 1;
		node.factor = rhsHeight - lhsHeight;
	}

	public Node balance(Node node) {
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

	public Node leftLeftCase(Node node) {
		return rightRotation(node);
	}

	public Node leftRightCase(Node node) {
		node.lhs = leftRotation(node.lhs);
		return leftLeftCase(node);
	}

	public Node rightRightCase(Node node) {
		return leftRotation(node);
	}

	public Node rightLeftCase(Node node) {
		node.rhs = rightRotation(node.rhs);
		return rightRightCase(node);
	}

	public Node leftRotation(Node node) {
		Node parent = node.rhs;
		node.rhs = parent.lhs;
		parent.lhs = node;
		update(node);
		update(parent);
		return parent;
	}

	public Node rightRotation(Node node) {
		Node newParent = node.lhs;
		node.lhs = newParent.rhs;
		newParent.rhs = node;
		update(node);
		update(newParent);
		return newParent;
	}

	public boolean delete(double data) {
		if (find(root, data)) {
			root = delete(root, data);
			nodeCount--;
			return true;
		}
		return false;
	}

	public Node delete(Node node, double data) {
		if (data < node.data)
			node.lhs = delete(node.lhs, data);
		else if (data > node.data)
			node.rhs = delete(node.rhs, data);
		else {
			if (node.lhs == null)
        		return node.rhs;
			else if (node.rhs == null)
				return node.lhs;
			else {
				if (node.lhs.height > node.rhs.height) {
					double successorVal = findMax(node.lhs);
					node.data = successorVal;
					node.lhs = delete(node.lhs, successorVal);
				} else {
					double successorVal = findMin(node.rhs);
					node.data = successorVal;
					node.rhs = delete(node.rhs, successorVal);
				}
			}
		}
		update(node);
		return balance(node);
	}

	public double findMin(Node node) {
		while (node.lhs != null)
			node = node.lhs;
		return node.data;
	}

	public double findMax(Node node) {
		while (node.rhs != null)
			node = node.rhs;
		return node.data;
	}
  	
  	public boolean valid(Node node) {
    	if (node == null) return true;
		boolean valid = true;
		if (node.lhs != null) valid = valid && node.lhs.data < node.data;
		if (node.rhs != null) valid = valid && node.rhs.data < node.data;
		return valid && valid(node.lhs) && valid(node.rhs);
	}
}