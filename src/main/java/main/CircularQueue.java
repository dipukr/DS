package main;

import common.Error;

public class CircularQueue {

	private Object[] data;
	private int capacity;
	private int front;
	private int rear;

	public CircularQueue(int capacity) {
		this.data = new Object[capacity];
		this.capacity = capacity;
		this.front = -1;
		this.rear = -1;
	}

	public void enqueue(Object elem) {
		if (full()) Error.fatal("Queue overflow.");
		if (empty()) front = 0;
		rear = (rear + 1) % capacity;
		data[rear] = elem;
	}

	public Object dequeue() {
		if (empty()) Error.fatal("Queue empty.");
		Object retval = data[front];
		if (front == rear) front = rear = -1;
		else front = (front + 1) % capacity;
		return retval;
	}

	public Object front() {
		if (empty()) Error.fatal("Queue empty.");
		return data[front];
	}

	public boolean full() {
		return (front == (rear + 1) % capacity);
	}

	public int size() {
		if (empty()) return 0;
		if (rear >= front) return rear - front + 1;
		return capacity - front + rear + 1;
	}

	public boolean empty() {
		return front == -1;
	}
}