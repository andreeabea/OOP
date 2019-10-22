package l2;
import java.util.*;
import java.math.BigInteger;
public class T4 {
	public static BigInteger encode(char c)
	{
		BigInteger x;
		int ch;
		switch(c)
		{
		case ' ' : x=new BigInteger("0");
		break;
		case ',' : x=new BigInteger("1");
		break;
		case '.' : x=new BigInteger("2");
		break;
		default : ch=(int)c-62; 
			      x=new BigInteger(""+ch);
	    break;
		}
		return x;
	}
	public static final BigInteger aHundred= new BigInteger("100");
    public static void main(String args[])
    {
    	Scanner in= new Scanner(System.in);
    	String phrase= in.nextLine();
    	BigInteger encoded=new BigInteger("0");
    	for(int i=0;i<phrase.length();i++)
    	{
    		BigInteger c;
    		c=encode(phrase.charAt(i));
    		encoded=encoded.multiply(aHundred);
    		encoded=encoded.add(c);
    	}
    	System.out.println(encoded);
    	in.close();
    }
}
