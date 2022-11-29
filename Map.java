public class Map<Key, Value> {

	private class Node<Key, Value> {
		private Key key;
		private Value value;
		private Node<Key, Value> next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node<Key, Value>[] chains;
	private int chainc;
	private int count;

	public Map(int chainc) {
		this.count = 0;
		this.chainc = chainc;
		this.chains = new Node<Key, Value>[chainc];
	}

	public void resize(int chainc) {
		Map<Key, Value> temp = new Map<Key, Value>(chainc);
		for (int i = 0; i < chainc; i++)
			for (var node = chains[i]; node != null; node = node.next)
				temp.put(node.key, node.value);
		this.count = temp.count;
		this.chainc = temp.chainc;
		this.chains = temp.chains;
	}

	public void put(Key key, Value value) {
		if (count >= 10 * chainc)
			resize(2 * chainc);
		int i = hash(key);
		chains[i] = new Node(key, value, chains[i]);
		count++;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		int i = hash(key);
		for (var node = chains[i]; node != null; node = node.next) {
			if (key.equals(node.key))
				return node.value;
		}
		return null;
	}

	public int hash(Key key) {
		return key.hashCode() % chainc;
	}

	public boolean empty() {return count == 0;}
	public int size() {return count;}

	public static void main(String[] args) throws Exception {
		var m = new Map<Character, String>(8);
		m.put('A', "Atman");
		m.put('D', "Deepu");
		m.put('A', "Arjun");
		m.put('B', "Brahman");
		System.out.println(m.size()+m.get('A')+m.get('A'));
	}
}