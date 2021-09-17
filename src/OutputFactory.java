
public class OutputFactory {

	SystemWrapper systemWrapper;

	public OutputFactory(SystemWrapper systemWrapper) {
		this.systemWrapper = systemWrapper;
	}

	public Output create(String choice) {
		OutputType type = OutputType.valueOf(choice);
		return type.getInstance(this.systemWrapper);
	}
}
