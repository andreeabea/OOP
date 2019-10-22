package l7;

class MyException extends Exception
{
	public MyException() {};
	public MyException(String msg)
	{
		super(msg);
	}
}

class MyException2 extends Exception
{
	public MyException2() {};
	public MyException2(String msg)
	{
		super(msg);
	}
}

public class T4 extends Exception{
	
	public T4(String msg)
	{
		super(msg);
	}
	public static void f()
	{
		try
		{
			try
			{
				g();
			}
			catch(MyException e)
			{
				System.out.println("Caught exception g");
				throw new MyException2("Exception f thrown");
			}
		}
		catch(MyException2 e)
		{
			System.out.println("Caught exception f");
		}
	}
	public static void g() throws MyException
	{
		throw new MyException("Exception g thrown");
	}
	public static void main(String args[])
	{
		f();
	}
}
