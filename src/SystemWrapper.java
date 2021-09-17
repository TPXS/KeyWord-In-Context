public class SystemWrapper {

	private static SystemWrapper instance = new SystemWrapper();

	private SystemWrapper() {
	}

	public static SystemWrapper getInstance() {
		return instance;
	}

	public void println(Object toPrint) {
		System.out.println(toPrint);
	}

}