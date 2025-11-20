package main;

public class Main {
	public static int max(int[] data) {
		int ans = 0;
		int currans = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 1) {
				currans += 1;
			} else {
				currans = 0;
			}
		}
		return ans;
	}
	public static int max(int[][] data) {
		int ans = 0;
		int cr = 0;
		int cc = 0;
		int rows = data.length;
		int cols = data[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (data[r][c] == 1) {
					if (cr - r == cc - c) {
						ans = Math.max(ans, cr - r);
					}
				} else {
					cr = 0;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[][] data = {
				{0,1,1,0,1},
				{1,1,0,1,0},
				{0,1,1,1,0},
				{1,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,0,0}};
		System.out.println(max(data));
	}
}
