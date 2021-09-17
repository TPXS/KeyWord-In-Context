public class UserOptions {

	// List<String> options = Stream.of("Console",
	// "File").collect(Collectors.toList());
	String inputSelection;
	String outputSelection;

	public UserOptions(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		setInputPreference(scannerWrapper, systemWrapper);
		setOutputPreference(scannerWrapper, systemWrapper);
	}

	private void setInputPreference(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		this.inputSelection = askUser("Please enter FILE to input from file or CONSOLE to input from console:",
				systemWrapper, scannerWrapper);
	}

	private void setOutputPreference(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		this.outputSelection = askUser("Please enter FILE to output from file or CONSOLE to output from console:",
				systemWrapper, scannerWrapper);
	}

	private String askUser(String inputOrOutput, SystemWrapper systemWrapper, ScannerWrapper scannerWrapper) {
		systemWrapper.println(inputOrOutput);

		String response = scannerWrapper.nextLine();
		return response.toUpperCase();
	}
	/*
	 * 
	 * private void printOptions(SystemWrapper systemWrapper) {
	 * systemWrapper.println("type " + formatOptions()); }
	 * 
	 * private String formatOptions() { String formattedOptions =
	 * this.options.stream().map(n -> String.valueOf(n))
	 * .collect(Collectors.joining("\' \'", "\'", "\'")); return formattedOptions; }
	 */

}
