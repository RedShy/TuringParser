package turingparser;

public class OutOfTapeException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5848710583785070772L;

	public OutOfTapeException(String errorMessage)
	{
		super(errorMessage);
	}
}
