
public class TestLongMatrix {
	
	public static void main(String[] args) {
		  
	    // Create Integer arrays m1, m2
	    Long[][] m1 = new Long[][]{{1l, 2l, 3l}, {4l, 5l, 6l}, {1l, 1l, 1l}};
	    Long[][] m2 = new Long[][]{{1l, 1l, 1l}, {2l, 2l, 2l}, {0l, 0l, 0l}};

	    // Create an instance of IntegerMatrix
	    LongMatrix longMatrix = new LongMatrix();

	    System.out.println("\nm1 + m2 is ");
	    GenericMatrix.printResult(m1, m2, longMatrix.addMatrix(m1, m2), '+');

	    System.out.println("\nm1 * m2 is ");
	    GenericMatrix.printResult(
	      m1, m2, longMatrix.multiplyMatrix(m1, m2), '*');
	  }

}
