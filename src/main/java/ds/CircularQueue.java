package ds;

public class CircularQueue {

	private Object[] data;
	private int front;
	private int rear;
	private int count;

	public CircularQueue(int size) {
		this.data = new Object[size];
		this.front = -1;
		this.rear = -1;
		this.count = 0;
	}

	public void enqueue(Object elem) {
		if (full()) Error.fatal("Queue overflow.");
		rear = (rear + 1) % data.length;
		data[rear] = elem;
	}
	
	public Object dequeue() {
		if (empty()) Error.fatal("Queue empty.");
		front = (front + 1) % data.length;
		return data[front];
	}
	
	public Object front() {
		if (empty()) Error.fatal("Queue empty.");
		return data[front];
	}

	public boolean full() {
		if (front == 0 && rear == data.length-1)
			return true;
		if (front == rear + 1)
			return true;
		return false;
	}

	public int size() {
		return count;
	}
	
	public boolean empty() {
		return front == -1;
	}
}