import java.util.List;

public class OutputToConsole extends AbstractDataType implements Output {
	SystemWrapper systemWrapper;

	public OutputToConsole(SystemWrapper systemWrapper) {
		this.systemWrapper = systemWrapper;
	}

	@Override
	public void write(List<String> lines) {
		setLines(lines);

		for (String line : this.lines) {
			this.systemWrapper.println(line);
		}
	}

	@Override
	public void setLines(List<String> lines) {
		this.lines = lines;
	}

}
