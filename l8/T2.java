package l7;
import java.util.*;
public class T2 extends Exception {
	
	private String message;
	public T2(String msg)
	{
		super(msg);
		this.message=msg;
	}
	public void print()
	{
		System.out.println(this.message);
	}
	public static void main(String args[])
	{
		Scanner in= new Scanner(System.in);
		try
		{
			throw new T2(in.nextLine());
		}
		catch(T2 e)
		{
			e.print();
		}
		finally
		{
			System.out.println("been here");
			in.close();
		}
	}
	
}
