package main;

public class QueueArray {

	private int[] data;
	private int front;
	private int rear;
	private int count;

	public QueueArray(int size) {
		this.data = new int[size];
		this.front = 0;
		this.rear = -1;
		this.count = 0;
	}

	public void enqueue(int elem) {
		if (rear == data.length - 1) Error.fatal("Queue overflow.");
		data[++rear] = elem;
		count++;
	}

	public int dequeue() {
		if (empty()) Error.fatal("Queue empty.");
		return data[front++];
	}
	
	public int front() {
		if (empty()) Error.fatal("Queue empty.");
		return data[front];
	}

	public int size() {
		return count;
	}
	
	public boolean empty() {
		return front > rear;
	}
	
	public boolean notEmpty() {
		return !empty();
	}
}
