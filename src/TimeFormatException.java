
public class TimeFormatException extends Exception 
{
	public TimeFormatException()
	{
		super("Incorrect Time Format. Program will now end.");
	}
	
	public TimeFormatException(String message)
	{
		super(message);
	}
}
