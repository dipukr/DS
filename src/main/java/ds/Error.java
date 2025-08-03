package ds;

public class Error {
	
	public static final String WRONG_INPUT = "invalid input value";
	
	public static void fatal(String messge) {
		System.out.println("Fatal error: " + messge);
		System.exit(1);
	}
	
	public static void fatal(boolean flag, String messge) {
		if (flag) {
			System.out.println("Fatal error: " + messge);
			System.exit(1);
		}
	}
}
