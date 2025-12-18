package main;

public class CircularQueue {

	private Object[] data;
	private int capacity;
	private int head;
	private int tail;

	public CircularQueue(int capacity) {
		this.data = new Object[capacity];
		this.capacity = capacity;
		this.head = -1;
		this.tail = -1;
	}

	public void enqueue(Object elem) {
		if (full()) Error.fatal("Queue overflow.");
		if (empty()) head = tail = 0;
		else tail = (tail + 1) % capacity;
		data[tail] = elem;
	}

	public Object dequeue() {
		if (empty()) Error.fatal("Queue empty.");
		Object elem = data[head];
		if (head == tail) head = tail = -1;
		else head = (head + 1) % capacity;
		return elem;
	}

	public Object front() {
		if (empty()) Error.fatal("Queue empty.");
		return data[head];
	}

	public boolean full() {
		return (head == (tail + 1) % capacity);
	}

	public int size() {
		if (empty()) return 0;
		if (tail >= head) return tail - head + 1;
		return capacity - head + tail + 1;
	}
	
	public int length() {
		if (empty()) return 0;
		return (tail - head + capacity) % capacity + 1;
	}

	public boolean empty() {
		return head == -1;
	}
}