package l2;
import java.util.*;
import java.math.BigInteger;
public class T5 {
	public static char decode(int x)
	{
		char c;
		switch(x)
		{
		case 0 : c=' ';
		break;
		case 1 : c=',';
		break;
		case 2 : c='.';
		break;
		default : c=(char)(x+62);
	    break;
		}
		return c;
    }
	public static final BigInteger ZERO= new BigInteger("0");
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		BigInteger encoded= in.nextBigInteger();
		String phrase=new String();
		while(encoded.compareTo(ZERO)>0)
		{
			
			int x=(encoded.mod(T4.aHundred)).intValue();
			phrase=decode(x)+phrase;
			encoded=encoded.divide(T4.aHundred);
		}
		System.out.println(phrase);
		in.close();
	}

}
