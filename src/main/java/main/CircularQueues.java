package main;

public class CircularQueues {

	private Object[] data;
	private int capacity;
	private int size;
	private int head;
	private int tail;

	public CircularQueues(int capacity) {
		this.data = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.head = 0;
		this.tail = -1;
	}

	public void enqueue(Object elem) {
		if (full()) Error.fatal("Queue overflow");
		tail = (tail + 1) % capacity;
		data[tail] = elem;
		size += 1;
	}

	public Object dequeue() {
		if (empty()) Error.fatal("Queue underflow");
		Object elem = data[head];
		head = (head + 1) % capacity;
		size -= 1;
		return elem;
	}

	public Object front() {
		if (empty()) Error.fatal("Queue underflow");
		return data[head];
	}

	public boolean full() {
		return (head == (tail + 1) % capacity);
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size() == 0;
	}
}
