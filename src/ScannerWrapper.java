import java.util.Scanner;

public class ScannerWrapper {

	private static ScannerWrapper instance = new ScannerWrapper();
	private static Scanner scanner;

	private ScannerWrapper() {
		scanner = new Scanner(System.in);

	}

	public static ScannerWrapper getInstance() {
		return instance;
	}

	public String nextLine() {
		return scanner.nextLine();
	}

	public void close() {
		instance = null;
		scanner.close();
	}
}
