public class UnionFind {

	private int[] parent;
	private int[] rank;

	public UnionFind(int n) {
		rank = new int[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			rank[i] = 1;
			parent[i] = i;
		}
	}

	public int find(int u) {
		int root = u;
		while (root != parent[root])
			root = parent[root];
		while (u != root) {
			int next = parent[u];
			parent[u] = root;
			u = next;
		}
		return root;
	}

	public boolean connected(int u, int v) {
		return find(u) == find(v);
	}

	public void union(int u, int v) {
		int r1 = find(u);
		int r2 = find(v);
		if (r1 == r2) return;
		if (rank[r1] < rank[r2]) {
			rank[r2] += rank[r1];
			parent[r1] = r2;
		} else {
			rank[r1] += rank[r2];
			parent[r2] = r1;
		}
	}
}