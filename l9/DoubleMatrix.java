
public class DoubleMatrix extends GenericMatrix<Double>{
	
    @Override
	protected Double add(Double d1, Double d2)
	{
		return d1+d2;
	}
	protected Double multiply(Double d1, Double d2)
	{
		return d1*d2;
	}
	protected Double zero() {
	    return 0.0;
	  }
}
