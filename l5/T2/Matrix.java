package l4;
import java.util.*;
public class Matrix {

	private int n,m;
	private float[][] matrix;
	private static int i,j;
	
	public Matrix(int n, int m)
	{
		this.n=n;
		this.m=m;
		this.matrix=new float[this.n][this.m];
		for(i=0;i<this.n;i++)
			for(j=0;j<this.m;j++)
				this.matrix[i][j]=0f;
	}
	public Matrix()
	{
		this(0,0);
	}
	public Matrix add(Matrix B)
	{
		Matrix C= null;
		if(this.n==B.getN() && this.m==B.getM())
		{
			C= new Matrix(B.getN(), B.getM());
			for(i=0;i<B.getN();i++)
				for(j=0;j<B.getM();j++)
					C.matrix[i][j]=matrix[i][j]+B.getMatrix(i,j);
		}
		if(C==null)
			System.out.println("The matrices do not have the same dimension");
		return C;
	}
	public Matrix substract(Matrix B)
	{
		Matrix C= null;
		if(this.n==B.getN() && this.m==B.getM())
		{
			C= new Matrix(B.getN(), B.getM());
			for(i=0;i<B.getN();i++)
				for(j=0;j<B.getM();j++)
					C.matrix[i][j]=this.matrix[i][j]-B.getMatrix(i,j);
		}
		if(C==null)
			System.out.println("The matrices do not have the same dimension");
		return C;
	}

	public Matrix multiply(Matrix B)
	{
		Matrix C= null;
		if(this.m==B.getN())
		{
			C= new Matrix(this.n, B.getM());
			for(i=0;i<this.n;i++)
				for(j=0;j<B.getM();j++)
					for(int k=0;k<this.m;k++)
					C.matrix[i][j]+=this.matrix[i][k]*B.getMatrix(k,j);
		}
		if(C==null)
			System.out.println("The matrices can't be multiplied");
		return C;
	}
	public Matrix divide(int value)
	{
		Matrix B= new Matrix(this.n,this.m);
		if(value!=0f)
		{
			for(i=0;i<this.n);i++)
				for(j=0;j<this.m;j++)
					B.matrix[i][j]=this.getMatrix(i,j)/value;
		}
		else System.out.println("Cannot divide by 0 !");
		return B;
	}
	public void scanMatrix(Scanner in)
	{
		this.n=in.nextInt();
		this.m=in.nextInt());
		this.matrix=new float[this.n][this.m];
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
				this.matrix[i][j]=in.nextFloat();
		
	}
	public void printMatrix()
	{
		for(i=0;i<this.n;i++)
			{
				for(j=0;j<this.m;j++)
					System.out.print(this.matrix[i][j]+" ");
				System.out.println();
			}
				
	}
	public static void main(String args[])
	{
		
		Matrix A, B, C = null;
		int val;
		Scanner in= new Scanner(System.in);
		A= new Matrix();
		A.scanMatrix(in);
		B= new Matrix();
		B.scanMatrix(in);
		
		System.out.println("1.add 2.substract 3.multiply 4.divide by value");
		int cmd= in.nextInt();
		switch(cmd)
		{
		case 1: C=A.add(B);
		break;
		case 2: C=A.substract(B);
		break;
		case 3: C=A.multiply(B);
		break;
		case 4: val=in.nextInt();
		C=A.divide(val);
		break;
		default: System.out.println("no command");
		break;
		}
		
		C.printMatrix();
		in.close();
	}
	public int getN()
	{
		return n;
	}
	public int getM()
	{
		return m;
	}
	public float getMatrix(int i, int j)
	{
		return matrix[i][j];
	}
	public void setN(int n)
	{
		this.n=n;
	}
	public void setM(int m)
	{
		this.m=m;
	}
	public void setMatrix(int i, int j, float x)
	{
		this.matrix[i][j]=x;
	}
}
