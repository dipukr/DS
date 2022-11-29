public class PriorityQueue<T extends Comparable<T>> {
	
	private BinaryHeap<T> heap = new BinaryHeap<T>();
	
	public void insert(T elem) {heap.insert(elem);}
	public T deleteMin() {return heap.deleteMin();}
	public T findMin() {return heap.findMin();}

	public int size() {return heap.size();}
	public boolean empty() {return heap.empty();}
}