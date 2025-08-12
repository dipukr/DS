package main;

import java.util.Arrays;
import java.util.LinkedList;

public class Adjacency {
	
	private boolean[][] matrix;
	private int size;

	public Adjacency(int size) {
		this.size = size;
		this.matrix = new boolean[size][size];
	}

	public void addEdge(int from, int to) {
		matrix[from][to] = true;
		matrix[to][from] = true;
	}

	public void removeEdge(int from, int to) {
		matrix[from][to] = false;
		matrix[to][from] = false;
	}

	public void BFS(int start) {
		boolean[] marked = new boolean[size];
		Arrays.fill(marked, false);
		var queue = new LinkedList<Integer>();
		marked[start] = true;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.printf("%d\t", u);
			for (int i = 0; i < size; i++) {
				if (matrix[u][i] && !marked[i]) {
					queue.offer(i);
					marked[i] = true;
				}
			}
		}
	}

	public int size() {
		return size;
	}
}