import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputToFile extends AbstractDataType implements Output {
	@Override
	public void write(List<String> lines) throws IOException {
		setLines(lines);
		FileWriter fileWriter = new FileWriter("kwic_output.txt");
		for (String line : this.lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();
	}

	@Override
	public void setLines(List<String> lines) {
		this.lines = lines;
	}
}
