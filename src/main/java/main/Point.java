package main;

public class Point {
	
	public int x;
	public int y;
	
	public static Point of(int x, int y) {
		Point point = new Point();
		point.x = x;
		point.y = y;
		return point;
	}
	
	@Override
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}
}
