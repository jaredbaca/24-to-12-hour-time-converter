import java.util.Scanner;

public class TimeConversion {
	
	private int hour;
	private int minute;
	private String response;
	
	public void setHour(int newHour) throws TimeFormatException
	{
		if(newHour >= 0 && newHour <= 24)
			{
				hour = newHour;
			}
		else throw new TimeFormatException();
	}
	
	public void setMinute(int newMinute) throws TimeFormatException
	{
		if(newMinute > 0 && newMinute < 60)
			{
				minute = newMinute;
			}
		else throw new TimeFormatException();
	}
	
	private boolean isAM()
	{
		if (hour < 12)
			return true;
		else 
			return false;
	}
	
	public void convertTime()
	{
		do
		{
			System.out.println("Please enter a time in 24 hour time:");
			Scanner keyboard = new Scanner(System.in);
			String initialTime = keyboard.nextLine();
			
			try 
			{
				if(initialTime.indexOf(':') == -1)
					throw new TimeFormatException();
					String s1 = initialTime.substring(0, initialTime.indexOf(':'));
					String s2 = initialTime.substring(initialTime.indexOf(':')+1);
				
				setHour(Integer.parseInt(s1));
				setMinute(Integer.parseInt(s2));	
			}
			catch(TimeFormatException e)
			{
				System.out.println(e.getMessage());
				System.exit(0);
			}
			
			System.out.println(initialTime + " converted to 12-hour time is ");
			if(hour <= 12)
				{System.out.print(hour);}
			else 
				{System.out.print(hour%12);}
			
			System.out.print(":");
			if(minute < 10)
				System.out.print("0");
			System.out.print(minute);
			
			if(isAM())
				{
					System.out.print("am");
				}
			else 
				{
					System.out.println("pm");
				}
			System.out.println();
			System.out.println("Try again?");
			response = keyboard.nextLine();
		}
		
		while(response.equalsIgnoreCase("yes"));
	}
	
	public static void main(String[] args)
	{
		TimeConversion test1 = new TimeConversion();
		test1.convertTime();
	}
	
}
