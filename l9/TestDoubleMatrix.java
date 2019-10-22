
public class TestDoubleMatrix {

	 public static void main(String[] args) 
	 {
	 Double[][] m1 = new Double[][]{{1.1, 2.2, 3.4}, {4.0, 5.1, 4.8}, {1.1, 1.2, 1.3}};
     Double[][] m2 = new Double[][]{{1.2, 1.0, 1.4}, {3.4, 4.3, 8.5}, {0.0, 0.0, 0.0}};
     
     DoubleMatrix doubleMatrix = new DoubleMatrix();

     System.out.println("\nm1 + m2 is ");
     GenericMatrix.printResult(m1, m2, doubleMatrix.addMatrix(m1, m2), '+');

     System.out.println("\nm1 * m2 is ");
     GenericMatrix.printResult(
       m1, m2, doubleMatrix.multiplyMatrix(m1, m2), '*');
	 }
}
