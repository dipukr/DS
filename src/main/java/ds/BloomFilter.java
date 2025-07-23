package ds;

import java.util.BitSet;
import java.util.zip.CRC32;
import java.util.zip.Adler32;

public class BloomFilter {
	private BitSet bitSet;
	private int bitSetSize;
	private int numHashFunctions;

	public BloomFilter(int size, int numHashFunctions) {
		this.bitSetSize = size;
		this.numHashFunctions = numHashFunctions;
		this.bitSet = new BitSet(bitSetSize);
	}

	public void add(String value) {
		int[] hashes = getHashes(value);
		for (int hash : hashes) {
			bitSet.set(Math.abs(hash % bitSetSize));
		}
	}

	public boolean mightContain(String value) {
		int[] hashes = getHashes(value);
		for (int hash : hashes) {
			if (!bitSet.get(Math.abs(hash % bitSetSize))) {
				return false;
			}
		}
		return true;
	}

	public int[] getHashes(String value) {
		int[] hashes = new int[numHashFunctions];

		for (int i = 0; i < numHashFunctions; i++) {
			String combined = i + value;
			int hash = combined.hashCode(); // basic hash
			hashes[i] = hash;
		}

		return hashes;
	}

	// Optional: stronger hash functions (CRC32, Adler32)
	public static int crc32(String input) {
		CRC32 crc = new CRC32();
		crc.update(input.getBytes());
		return (int) crc.getValue();
	}

	public static int adler32(String input) {
		Adler32 adler = new Adler32();
		adler.update(input.getBytes());
		return (int) adler.getValue();
	}

	public static void main(String[] args) {
		BloomFilter filter = new BloomFilter(1024, 3);

		filter.add("apple");
		filter.add("banana");

		System.out.println("apple: " + filter.mightContain("apple")); // true
		System.out.println("banana: " + filter.mightContain("banana")); // true
		System.out.println("grape: " + filter.mightContain("grape")); // false (probably)
	}
}
