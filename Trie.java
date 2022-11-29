import java.util.Map;
import java.util.HashMap;

public class Trie {

	private static class Node {
		public boolean word;
		public Node[] childs;
		public Node() {
			this.word = false;
			this.childs = new Node[26];
		}
	}

	private Node root = new Node();

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			if (curr.childs[c - 'a'] == null)
				curr.childs[c - 'a'] = new Node();
			curr = curr.childs[c - 'a'];
		}
		curr.word = true;
	}
	
	public boolean search(String word) {
		Node node = getNode(word);
		return node != null && node.word;
	}
	
	public boolean startsWith(String prefix) {
		return getNode(prefix) != null;
	}

	public Node getNode(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			if (curr.childs[c - 'a'] == null)
				return null;
			curr = curr.childs[c - 'a'];
		}
		return curr;
	}

	public static void main(String[] args) throws Exception {
		Trie trie = new Trie(); // leet208
		trie.insert("apple");
		assert trie.search("apple") == true;   // returns true
		assert trie.search("app") == false;     // returns false
		assert trie.startsWith("app") == true; // returns true
		trie.insert("app");   
		assert trie.search("app") == true;     // returns true
	}
}
