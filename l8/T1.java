package l7;
import java.util.*;
public class T1 extends Exception{
	
	public T1(String message)
	{
		super(message);
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		try
		{
			int n=in.nextInt();
			if(n<10)
				throw new T1("n is a digit");
		}
		catch(T1 e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("been here");
			in.close();
		}
	}

}
