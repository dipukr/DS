public class Tree<T> {

	private static class Node {
		public T data;
		public List<Node> childs;
		
		public Node(T data) {
			this.data = data;
			this.childs = new ArrayList<Node>();
		}

		public void addChild(Node child) {
			childs.add(child);
		}
	}

	private Node root = null;
	private int nodeCount = 0;

	public int size() {}
	public int height() {}
	public boolean empty() {}
}