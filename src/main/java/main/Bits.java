package main;

public class Bits {

	private long[] data;
	private int size;

	public Bits(int size) {
		this.data = new long[(size / 64) + 1];
		this.size = size;
	}

	public void add(int index) {
		data[index / 64] |= (1L << (index % 64));
	}

	public boolean contains(int index) {
		return (data[index / 64] & (1L << (index % 64))) != 0;
	}
}