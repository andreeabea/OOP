package l2;
import java.util.*;

public class T2 {
	
	public static boolean isDistinct(int[] v, int n, int x)
	{
		for(int i=0;i<n;i++)
			if(v[i]==x)
				return false;
		return true;
	}
	public static void random(int nbs, int range, int rand[])
	{
		int x,i;
		for(i=0;i<nbs;i++)
		{
			x=(int)(Math.random()*range)+1;
			if(isDistinct(rand,i,x))
				rand[i]=x;
			else i--;
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,k;
		n=in.nextInt();
		k=in.nextInt();
		int[] rand = new int[k];
		random(k,n,rand); //generates k random distinct numbers from 1 to n
		for(int i=0;i<k;i++)
			System.out.print(rand[i]+" ");
		in.close();
	}
}
