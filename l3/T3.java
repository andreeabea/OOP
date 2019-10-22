package l2;

public class T3 {

	private static final int ONE=1;
	private static int length=0;
	
	public static long reverse(long x) //reverses a bitstring
	{
		long r=0, aux=0;
		while(x>0)
		{
			aux=x&ONE; //last bit
			x=x>>ONE;
			r=r<<ONE;
			r=r|aux;
			length++;
		}
		return r;
	}
	public static void printAscOrDesc(long order, boolean asc)
	{
		int number=-1;
		for(int i=0;i<6;i++)
		{
			while((order&ONE)==0)
			{
				order=order>>ONE;
				number++;
			}
			order=order>>ONE;
			number++;
			if(asc==true)
				System.out.print(number+" "); //prints ascending
			else System.out.print((length-number-1)+" "); //descending
		}
		
	}

	public static void main(String args[])
	{
		int[] rand = new int[6];
		int i;
		long order=0;
		T2.random(6, 49, rand);
		
		for(i=0;i<6;i++)
		{
		    long bitstring=1;
			bitstring=bitstring<<rand[i];
			order= order | bitstring;
		}

		System.out.print("Ascending order: ");
		printAscOrDesc(order,true);
		order=reverse(order);
		System.out.print("\nDescending order: ");
	    printAscOrDesc(order,false);
	}

}
