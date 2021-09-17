import java.util.ArrayList;
import java.util.List;

public class InputFromConsole extends AbstractDataType implements Input {

	SystemWrapper systemWrapper;
	ScannerWrapper scannerWrapper;

	public InputFromConsole(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		this.systemWrapper = systemWrapper;
		this.scannerWrapper = scannerWrapper;
	}

	private List<String> readInputToList() {
		List<String> linesInInput = new ArrayList<String>();
		String line = this.scannerWrapper.nextLine();

		while (!line.equals("-1")) {
			linesInInput.add(line);
			line = this.scannerWrapper.nextLine();
		}

		return linesInInput;
	}

	@Override
	public void setLines() {
		this.lines = readInputToList();
	}

	private void promptUser() {
		this.systemWrapper.println("Please enter lines to add, then enter -1 to finish:");
	}

	@Override
	public List<String> read() {
		promptUser();
		setLines();

		return this.lines;
	}

}