public class QueueArray<T> {

	private T[] data;
	private int front;
	private int rear;
	private int count;

	public QueueArray(int size) {
		this.data = (T[]) new Object[size];
		this.front = 0;
		this.rear = -1;
		this.count = 0;
	}

	public void enqueue(T elem) {
		if (rear == data.length-1) throw new Error("Queue overflow");
		data[++rear] = elem;
		count++;
	}

	public T dequeue() {
		if (empty()) throw new Error("Queue empty");
		return data[front++];
	}
	
	public T front() {
		if (empty()) throw new Error("Queue empty");
		return data[front];
	}

	public int size() {return count;}
	public boolean empty() {return front > rear;}

	public static void main(String[] args) throws Exception {
		var q = new Queue2<String>(10);
		q.enqueue("Satyam");
		q.enqueue("Gyanam");
		q.enqueue("Anantam");
		while (!q.empty())
			System.out.println(q.dequeue());
	}
}
