package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTree {

	private static final int T = 3; // order of B+ tree (max children = 2*T)
	private Node root = new LeafNode();;

	public abstract class Node {	
		public List<Integer> keys = new ArrayList<>();
		public abstract LeafNode findLeaf(int key);
		public abstract void insert(int key, int value);
		public abstract boolean isOverflow();
		public abstract Node split();
		public abstract int getFirstKey();
	}

	public class InternalNode extends Node {
		public List<Node> childs = new ArrayList<>();

		@Override
		public LeafNode findLeaf(int key) {
			int i = Collections.binarySearch(keys, key);
			int childIndex = i >= 0 ? i + 1 : -i - 1;
			return childs.get(childIndex).findLeaf(key);
		}

		@Override
		public void insert(int key, int value) {
			LeafNode leaf = findLeaf(key);
			leaf.insert(key, value);

			if (leaf.isOverflow()) {
				Node sibling = leaf.split();
				insertChild(sibling.getFirstKey(), sibling);
			}

			if (root.isOverflow()) {
				Node sibling = split();
				InternalNode newRoot = new InternalNode();
				newRoot.keys.add(sibling.getFirstKey());
				newRoot.childs.add(this);
				newRoot.childs.add(sibling);
				root = newRoot;
			}
		}

		void insertChild(int key, Node child) {
			int i = Collections.binarySearch(keys, key);
			int pos = i >= 0 ? i + 1 : -i - 1;
			keys.add(pos, key);
			childs.add(pos + 1, child);
		}

		@Override
		public boolean isOverflow() {
			return childs.size() > 2 * T;
		}

		@Override
		public Node split() {
			int from = keys.size() / 2 + 1, to = keys.size();

			InternalNode sibling = new InternalNode();
			sibling.keys.addAll(keys.subList(from, to));
			sibling.childs.addAll(childs.subList(from, childs.size()));

			keys.subList(from - 1, to).clear();
			childs.subList(from, childs.size()).clear();

			return sibling;
		}

		public int getFirstKey() {
			return childs.get(0).getFirstKey();
		}
	}

	public class LeafNode extends Node {
		public List<Integer> values = new ArrayList<>();
		public LeafNode next = null;

		@Override
		public LeafNode findLeaf(int key) {
			return this;
		}

		@Override
		public void insert(int key, int value) {
			int i = Collections.binarySearch(keys, key);
			if (i >= 0) {
				values.set(i, value); // update
			} else {
				int pos = -i - 1;
				keys.add(pos, key);
				values.add(pos, value);
			}
		}

		@Override
		public boolean isOverflow() {
			return keys.size() > 2 * T - 1;
		}

		@Override
		public Node split() {
			LeafNode sibling = new LeafNode();
			int from = (keys.size() + 1) / 2;

			sibling.keys.addAll(keys.subList(from, keys.size()));
			sibling.values.addAll(values.subList(from, values.size()));

			keys.subList(from, keys.size()).clear();
			values.subList(from, values.size()).clear();

			sibling.next = this.next;
			this.next = sibling;

			return sibling;
		}

		public int getFirstKey() {
			return keys.get(0);
		}
	}

	public BTree() {
		root = new LeafNode();
	}

	public void insert(int key, int value) {
		root.insert(key, value);
	}

	public Integer search(int key) {
		LeafNode leaf = root.findLeaf(key);
		int i = Collections.binarySearch(leaf.keys, key);
		if (i >= 0) {
			return leaf.values.get(i);
		}
		return null;
	}

	public void printTree() {
		Queue<Node> queue = new Queue<>();
		queue.enqueue(root);
		while (!queue.empty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.dequeue();
				System.out.print(node.keys + " ");
				if (node instanceof InternalNode) {
					List<Node> childs = ((InternalNode) node).childs;
					for (Node child: childs)
						queue.enqueue(child);
				}
			}
			System.out.println();
		}
	}
}
