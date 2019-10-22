
public class LongMatrix extends GenericMatrix<Long>{
	
		protected Long add(Long l1, Long l2)
		{
			return l1+l2;
		}
		protected Long multiply(Long l1, Long l2)
		{
			return l1*l2;
		}
		protected Long zero() {
		    return (long) 0;
		  }

}
