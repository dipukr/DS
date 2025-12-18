package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ConsistentHash {
	private TreeMap<Long, Node> ring = new TreeMap<>();
	private List<Node> nodes = new ArrayList<>();

	public void addNode(Node node) {
		nodes.add(node);
		long hash = Tools.hash(node.getId());
		ring.put(hash, node);
		Entry<Long, Node> lowerEntry = ring.lowerEntry(hash);
		long start = (lowerEntry == null) ? ring.lastKey() : lowerEntry.getKey();
		long end = hash;
		Node predecessor = (lowerEntry == null) ? ring.get(ring.lastKey()) : lowerEntry.getValue();
		Node successor = node;
		moveKeysInRange(predecessor, successor, start, end);
	}
	
	public void removeNode(Node node) {
		nodes.remove(node);
		long hash = Tools.hash(node.getId());
		Entry<Long, Node> nextEntry = ring.higherEntry(hash);
		if (nextEntry == null) nextEntry = ring.firstEntry();
		Node successor = nextEntry.getValue();
		successor.getData().putAll(node.getData());
		ring.remove(hash);
	}

	public void moveKeysInRange(Node from, Node to, long start, long end) {
		List<String> toMove = new ArrayList<>();
		for (String key: from.getData().keySet()) {
			long keyHash = Tools.hash(key);
			boolean inRange = (start < end) ? 
					(keyHash > start && keyHash <= end) : 
					(keyHash > start || keyHash <= end);
			if (inRange) {
				to.put(key, from.get(key));
				toMove.add(key);
			}
		}
		from.removeKeys(toMove);
	}

	public Node getNode(String key) {
		if (ring.isEmpty()) return null;
		long hash = Tools.hash(key);
		Entry<Long, Node> entry = ring.ceilingEntry(hash);
		if (entry == null) entry = ring.firstEntry();
		return entry.getValue();
	}
	
	public List<Node> getAllNodes() {
		return nodes;
	}
}
