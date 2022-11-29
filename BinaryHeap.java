import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
	
	private T[] data;
	private int size;

	public BinaryHeap() {
		this.data = (T[]) new Comparable[8];
		this.size = 0;
	}

	public int size() {return size;}
	public boolean empty() {return size() == 0;}
	
	public void insert(T elem) {
		if (size == data.length)
			data = Arrays.copyOf(data, data.length*2);
		data[size++] = elem;
		bubbleUp();
	}

	public T deleteMin() {
		T val = findMin();
		data[0] = data[size-1];
		data[size-1] = null;
		size--;
		bubbleDown();
		return val;
	}

	public T findMin() {
		if (empty())
			throw new Error("overflow");
		return data[0];
	}

	private void bubbleUp() {
		int i = size-1;
		while (hasParent(i) && data[parent(i)].compareTo(data[i]) > 0) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	private void bubbleDown() {
		int i = 0;
		while (hasLeft(i)) {
			int smaller = left(i);
			if (hasRight(i) && data[left(i)].compareTo(data[right(i)]) > 0)
				smaller = right(i);
			if (data[i].compareTo(data[smaller]) > 0)
				swap(i, smaller);
			else break;
			i = smaller;
		}
	}

	private void swap(int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private int left(int i) {return i*2+1;}
	private int right(int i) {return i*2+2;}
	private int parent(int i) {return (i-1)/2;}

	private boolean hasParent(int i) {return i > 0;}
	private boolean hasLeft(int i) {return left(i) < size; }
	private boolean hasRight(int i) {return right(i) < size;}
}
