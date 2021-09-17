import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter extends AbstractDataType implements SetLinesHasInput {

	public List<String> shiftLines(List<String> lines) {
		setLines(collectShiftedLines(lines));

		return this.lines;
	}

	@Override
	public void setLines(List<String> collectedShiftedLines) {
		this.lines = collectedShiftedLines;
	}

	private List<String> collectShiftedLines(List<String> lines) {
		List<ArrayList<String>> shiftedLines = circularizeAllLines(lines);
		List<String> collectedShiftedLines = new ArrayList<String>();

		for (ArrayList<String> line : shiftedLines) {
			collectedShiftedLines.add(wordListToString(line));
		}

		return collectedShiftedLines;
	}

	private String wordListToString(ArrayList<String> wordList) {
		StringBuilder stringBuilder = new StringBuilder();

		for (String word : wordList) {
			stringBuilder.append(word);
			stringBuilder.append(" ");
		}

		String line = stringBuilder.toString().trim();

		return line;
	}

	private List<ArrayList<String>> circularizeAllLines(List<String> lines) {
		List<ArrayList<String>> circularizedLines = new ArrayList<ArrayList<String>>();

		for (ArrayList<String> line : linesToWordList(lines)) {
			for (ArrayList<String> shiftedLine : circularizeLine(line)) {
				circularizedLines.add(shiftedLine);
			}
		}

		return circularizedLines;
	}

	private List<ArrayList<String>> circularizeLine(ArrayList<String> line) {
		List<ArrayList<String>> circularizedLine = new ArrayList<ArrayList<String>>();

		for (int firstWordInLineIndex = 0; firstWordInLineIndex < line.size(); firstWordInLineIndex++) {
			ArrayList<String> shiftedLine = new ArrayList<String>();

			for (int i = firstWordInLineIndex; i < firstWordInLineIndex + line.size(); i++) {
				shiftedLine.add(line.get(i % line.size()));
			}
			circularizedLine.add(shiftedLine);
		}

		return circularizedLine;
	}

	private List<ArrayList<String>> linesToWordList(List<String> lines) {
		List<ArrayList<String>> lineWordList = new ArrayList<ArrayList<String>>();

		for (String line : lines) {
			lineWordList.add(lineToWordList(line));
		}

		return lineWordList;
	}

	private ArrayList<String> lineToWordList(String line) {
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(line.split("\\s")));

		return wordList;
	}

}
