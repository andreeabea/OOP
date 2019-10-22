package l2;

public class T6 {
	public static boolean isPrime(int x)
	{
		int i;
		for(i=2;i<=Math.sqrt(x);i++)
			if(x%i==0)
				return false;
		return true;
	}
	public static int generatePrimes(int v[],int n)
	{
		int k=1;
		v[0]=2;
		for(int i=3;i<=n-2;i=i+2)
			if(isPrime(i))
				v[k++]=i;
		return k;
	}
	public static void checkGoldbach(int m, int n, int v[], int nbs)
	{
		for(int i=m;i<=n;i=i+2)
		{
			int left=0;
			int right=nbs-1;
			while(left<=right)
			{
				if(v[left]+v[right]==i)
				{
					System.out.println(i+"= "+v[left]+"+"+v[right]);
					break;
				}
				else if(v[left]+v[right]<i)
					left++;
				else if(v[left]+v[right]>i)
					right--;
			}
			
		}
		
	}
	public static void main(String args[])
	{
		int m=Integer.parseInt(args[0]);
		int n=Integer.parseInt(args[1]);
		int[] primes=new int[n-2];
		int nbs;
		nbs=generatePrimes(primes,n);
	
		if(m%2!=0)
			checkGoldbach(m+1,n,primes,nbs);
		else checkGoldbach(m,n,primes,nbs);
		
	}
}
