import java.io.IOException;

public class Mouse {
	public String name;
	protected int house = 10;
	public void run() {
		System.out.print("1 ");
		try {
			System.out.print("2 ");
			name.toString();
			System.out.print("3 ");
		} catch (NullPointerException e) {
			System.out.print("4 ");
			throw e;
		}
		System.out.print("5 ");
	}
	
	public void print() throws RuntimeException{
		System.out.println("In parent class. ");
	}

	public static void main(String[] args) {
//		Mouse jerry = new Mouse();
//		jerry.run();
//		System.out.print("6 ");
		Object obj = new Integer(3);
		String str = (String) obj;
		System.out.println(str); 
	}
}
