import java.util.List;

public class Alphabetizer extends AbstractDataType implements SetLinesHasInput {

	private void sortLines() { // Complexity O(n^2)
								// TODO: Change to MSD Radix sort O(d*(n +B)) if sort will be applied to a set
								// of lines with cardinality greater than 76 (based on line length of 80
								// characters and 37 possible characters {[0 - Z] U "\s"})
		int numberOfLines = this.lines.size();
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = i + 1; j < numberOfLines; j++) {
				if (this.lines.get(i).compareToIgnoreCase(this.lines.get(j)) > 0) {
					String temp = lines.get(i);
					this.lines.set(i, this.lines.get(j));
					this.lines.set(j, temp);
				}
			}
		}
	}

	@Override
	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public List<String> sort(List<String> lines) {
		setLines(lines);
		sortLines();
		return this.lines;
	}

}
