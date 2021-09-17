
public class InputFactory {

	ScannerWrapper scannerWrapper;
	SystemWrapper systemWrapper;

	public InputFactory(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		this.scannerWrapper = scannerWrapper;
		this.systemWrapper = systemWrapper;
	}

	public Input create(String choice) {
		switch (choice.toUpperCase()) {
		case "CONSOLE":
			return new InputFromConsole(this.scannerWrapper, this.systemWrapper);
		case "FILE":
			return new InputFromFile();
		default:
			throw new IllegalArgumentException();
		}
	}
}
