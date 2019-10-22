package l7;

public class T3 {
	public static String string = null;
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println(string.charAt(10));
		} 
		catch(NullPointerException e) 
		{
			System.err.println("Caught NullPointerException");
			e.printStackTrace();
		} 
		
		try 
		{
			string = "my string";
			System.out.println(string);
		} 
		catch(NullPointerException e) 
		{
			System.out.println("Caught NullPointerException");
			e.printStackTrace();
		} 
		finally 
		{
			System.out.println("been here");
		}
	}
}
