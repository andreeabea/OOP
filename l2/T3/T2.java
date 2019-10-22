package l1;
import java.util.*;
public class T2 {

	public static void main(String args[])
	{
		byte minByte=Byte.MIN_VALUE, maxByte=Byte.MAX_VALUE;
		short minShort=Short.MIN_VALUE, maxShort=Short.MAX_VALUE;
		int minInt=Integer.MIN_VALUE, maxInt=Integer.MAX_VALUE;
		long minLong=Long.MIN_VALUE, maxLong=Long.MAX_VALUE,x,y;
		float maxFloat=Float.MAX_VALUE,f;
		double maxDouble=Double.MAX_VALUE,d;
		
		Scanner in= new Scanner(System.in);
		x=in.nextLong();
		maxByte+=(byte)x;
		maxShort+=(short)x;
		maxInt+=(int)x;
		maxLong+=x;
		System.out.println(maxByte+"\n"+maxShort+"\n"+maxInt+"\n"+maxLong+"\n");
		
		y=in.nextLong();
		minByte-=(byte)y;
		minShort-=(short)y;
		minInt-=(int)y;
		minLong-=y;
		System.out.println(minByte+"\n"+minShort+"\n"+minInt+"\n"+minLong+"\n");
		
		f=maxFloat*10.0F;
		d=maxDouble*10.0;
		System.out.println(f+"\n"+d+"\n");
		
		maxFloat-=f;
		maxDouble-=d;
		System.out.println(maxFloat+"\n"+maxDouble);
		in.close();
	}

}