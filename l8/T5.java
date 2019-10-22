package l7;

class MyEx extends Exception
{
	public MyEx() {};
	public MyEx(String msg)
	{
		super(msg);
		System.out.println(msg);
		System.out.println("Caught exception");
	}
}

class MyEx2 extends MyEx
{
	public MyEx2() {};
	public MyEx2(String msg)
	{
		super(msg);
		System.out.println(msg);
		System.out.println("Caught exception 2");
	}
}

class MyEx3 extends MyEx2
{
	public MyEx3() {};
	public MyEx3(String msg)
	{
		super(msg);
		System.out.println(msg); 
		System.out.println("Caught exception 3");
	}
}

class A
{
	void f() throws MyEx
	{
		throw new MyEx("Exception A thrown");
	}
}

class B extends A
{
	void f() throws MyEx2
	{
		throw new MyEx2("Exception B thrown");
	}
}

class C extends B
{
	void f() throws MyEx3
	{
		throw new MyEx3("Exception C thrown");
	}
}

public class T5 extends Exception {
	
	public static void main(String[] args)
	{
		C objectC = new C();
		A objectA = (A)objectC;
		try
		{
			objectA.f();
		}
		catch(MyEx e)
		{
			System.out.println("Caught exception");
		}
		finally
		{
			System.out.println("Caught exceptions");
		}
		
	}

}
