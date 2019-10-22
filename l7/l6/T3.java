package l6;

import l6interf.MyInterface;

public class T3 extends Subclass implements MyInterface {

	public static void main(String args[])
	{
		T3 c=new T3();
		method1(c);
		method2(c);
		method3(c);
		method4(c);
	}
	public void method() {
		System.out.println("My interface");
	}
    public static void method1(I1 i)
    {
    	System.out.println("interface 1");
    }
    public static void method2(I2 i)
    {
    	System.out.println("interface 2");
    }
    public static void method3(I3 i)
    {
    	System.out.println("interface 3");
    }
    public static void method4(MyInterface i)
    {
    	System.out.println("main interface");
    }
}
