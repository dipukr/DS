package main;

public class Btree {

	private static final int T = 3; // Minimum degree
	private Node root = new Node();

	public class Node {
		public int n; // Current number of keys
		public int[] keys = new int[2 * T - 1];
		public Node[] childs = new Node[2 * T];
		public boolean leaf = true;

		// Search for key in subtree rooted with this node
		public boolean search(int key) {
			int i = 0;
			while (i < n && key > keys[i])
				i += 1;
			if (i < n && keys[i] == key) return true;
			if (leaf) return false;
			return childs[i].search(key);
		}

		// Insert a key into a non-full node
		public void insertNonFull(int key) {
			int i = n - 1;
			if (leaf) {
				// Insert into leaf
				while (i >= 0 && keys[i] > key) {
					keys[i + 1] = keys[i];
					i--;
				}
				keys[i + 1] = key;
				n++;
			} else {
				// Insert into internal node
				while (i >= 0 && keys[i] > key)
					i--;

				if (childs[i + 1].n == 2 * T - 1) {
					splitChild(i + 1, childs[i + 1]);
					if (key > keys[i + 1])
						i++;
				}
				childs[i + 1].insertNonFull(key);
			}
		}

		// Split the full child node
		public void splitChild(int i, Node y) {
			Node z = new Node();
			z.leaf = y.leaf;
			z.n = T - 1;

			// Copy last (T - 1) keys to z
			for (int j = 0; j < T - 1; j++) {
				z.keys[j] = y.keys[j + T];
			}

			if (!y.leaf) {
				for (int j = 0; j < T; j++) {
					z.childs[j] = y.childs[j + T];
				}
			}

			y.n = T - 1;

			// Shift childs and keys in this node
			for (int j = n; j >= i + 1; j--) {
				childs[j + 1] = childs[j];
			}
			childs[i + 1] = z;

			for (int j = n - 1; j >= i; j--) {
				keys[j + 1] = keys[j];
			}
			keys[i] = y.keys[T - 1];
			n++;
		}
	}

	public void insert(int key) {
		if (root.n == 2 * T - 1) {
			Node node = new Node();
			node.leaf = false;
			node.childs[0] = root;
			node.splitChild(0, root);
			root = node;
		}
		root.insertNonFull(key);
	}

	public boolean search(int key) {
		return root.search(key);
	}

	public static void main(String[] args) {
		Btree tree = new Btree();
		for (int key: new int[]{4,8,6,2,10,3,9,5,7,1})
			tree.insert(key);
		System.out.println("\nSearch for 6: " + tree.search(6));
		System.out.println("Search for 15: " + tree.search(15));
	}
}
