import java.io.IOException;
import java.util.List;

public interface Output extends SetLinesHasInput {
	public void write(List<String> lines) throws IOException;
}
