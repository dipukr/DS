public class Main {
	public static void main(String[] args) throws Exception {
		var list = new SinglyList<Integer>();
		for (int i = 1; i < 10; i++)
			list.pushFront(i*100);
		list.reverseR();
		list.print();
	}
}