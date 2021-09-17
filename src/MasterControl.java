import java.io.IOException;
import java.util.List;

public class MasterControl extends AbstractDataType implements SetLinesHasInput {

	String inputSelection;
	String outputSelection;

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		runUserOptions(scannerWrapper, systemWrapper);
		runInput(scannerWrapper, systemWrapper);
		runCircularShifter();
		runAlphabetizer();
		runOutput(systemWrapper);
	}

	private void runUserOptions(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		UserOptions userOptions = new UserOptions(scannerWrapper, systemWrapper);
		this.inputSelection = userOptions.inputSelection;
		this.outputSelection = userOptions.outputSelection;

	}

	private void runInput(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		InputFactory inputFactory = new InputFactory(scannerWrapper, systemWrapper);
		Input input = inputFactory.create(inputSelection);

		setLines(input.read());
		scannerWrapper.close();
	}

	private void runCircularShifter() {
		CircularShifter circularShifter = new CircularShifter();
		circularShifter.setLines(this.lines);
		setLines(circularShifter.shiftLines(circularShifter.lines));
	}

	private void runAlphabetizer() {
		Alphabetizer alphabetizer = new Alphabetizer();
		alphabetizer.setLines(this.lines);
		setLines(alphabetizer.sort(alphabetizer.lines));
	}

	private void runOutput(SystemWrapper systemWrapper) {
		OutputFactory outputFactory = new OutputFactory(systemWrapper);
		Output output = outputFactory.create(outputSelection);

		try {
			output.write(this.lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setLines(List<String> lines) {
		this.lines = lines;

	}

	public static void main(String[] args) {
		MasterControl masterControl = new MasterControl();
		masterControl.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());
	}

}
