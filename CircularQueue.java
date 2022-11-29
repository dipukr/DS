public class CircularQueue<T> {

	private T[] data;
	private int front;
	private int rear;
	private int count;

	public CircularQueue(int size) {
		this.data = (T[]) new Object[size];
		this.front = -1;
		this.rear = -1;
		this.count = 0;
	}

	public void enqueue(T elem) {
		if (full()) throw new Error("Queue overflow");
		rear = (rear + 1) % data.length;
		data[rear] = elem;
	}
	
	public T dequeue() {
		if (empty()) throw new Error("Queue empty");
		front = (front + 1) % data.length;
		return data[front];
	}
	
	public T front() {
		if (empty()) throw new Error("Queue empty");
		return data[front];
	}

	public boolean full() {
		if (front == 0 && rear == data.length-1)
			return true;
		if (front == rear + 1)
			return true;
		return false;
	}

	public int size() {return count;}
	public boolean empty() {return front == -1;}
}