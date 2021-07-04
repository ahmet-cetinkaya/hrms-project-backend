package ahmetcetinkaya.HRMSProjectBackend.core.utilities.results;

public class DataResult<T> extends Result {
	private final T data;

	public DataResult(final T data, final boolean success) {
		super(success);
		this.data = data;
	}

	public DataResult(final T data, final boolean success, final String message) {
		super(success, message);
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
