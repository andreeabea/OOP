package l1;
import java.util.*;
import java.math.BigInteger;

public class T1 {
	
public static void main(String args[])
{
	//print 2^i-1
	Scanner in=new Scanner(System.in);
	BigInteger x= new BigInteger("2");
	int i=in.nextInt();
    x=x.pow(i-1);
    System.out.println(x);
    in.close();
    
    long n=10,sum;
    sum=n+Long.parseLong(x.toString());
	System.out.println(sum);
	
}
}