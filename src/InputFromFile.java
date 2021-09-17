import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFromFile extends AbstractDataType implements Input {

	private List<String> readInputFileToList() {
		Path filePath = FileSystems.getDefault().getPath("./", "kwic.txt");
		List<String> linesInInputFile = new ArrayList<String>();

		try (Stream<String> inputStream = Files.lines(filePath)) {
			linesInInputFile = inputStream.collect(Collectors.toList());
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return linesInInputFile;
	}

	@Override
	public void setLines() {
		this.lines = readInputFileToList();
	}

	@Override
	public List<String> read() {
		setLines();
		return this.lines;
	}
}