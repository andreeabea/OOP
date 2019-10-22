package l2;
import java.util.*;
import java.math.BigInteger;

public class T1 {
	public static final BigInteger ONE= new BigInteger("1");
	public static BigInteger factorial(BigInteger n)
	{
		BigInteger fact = new BigInteger("1");
		BigInteger i= new BigInteger("1");
		
		while(i.compareTo(n)<=0)
		{
			fact=fact.multiply(i);
			i=i.add(ONE);
		}
		return fact;
	}
	public static int combinations(BigInteger n, BigInteger k)
	{
		BigInteger kfact, nkfact, diff, denominator, nfact, result;
		int res;
		kfact=factorial(k);
		diff=n.subtract(k);
		nkfact=factorial(diff);
		denominator=kfact.multiply(nkfact);
		nfact=factorial(n);
		res=nfact.divide(denominator).intValue();
		return res;
	}
	
	public static void main(String args[]) 
	{
		Scanner in= new Scanner(System.in);
		BigInteger n,k;
		int lottery;
		n=in.nextBigInteger();
		k=in.nextBigInteger();
		lottery=combinations(n,k);
		System.out.println(lottery);
		in.close();
	}
}
