package ds;

public class Main {
	public static void main(final String[] args) {
		var cq = new CircularQueue(3);
		cq.enqueue(100);
		cq.enqueue(200);
		cq.enqueue(300);
		System.out.println(cq.size());
		while (!cq.empty()) {
			System.out.println(cq.dequeue());
		}
	}
}
