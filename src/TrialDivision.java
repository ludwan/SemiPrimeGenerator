import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;


public class TrialDivision {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(args[0])));
		try {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	long start = System.nanoTime();
		    	System.out.println("Factors: " + tdFactors(new BigInteger(line)) + " Time: " + (System.nanoTime() - start));
		    }
		} finally {
		    br.close();
		}
		
		
		
		
	}
	
	public static LinkedList<BigInteger> tdFactors(BigInteger n)
	{
		int counter = 0;
	    BigInteger two = BigInteger.valueOf(2);
	    LinkedList<BigInteger> fs = new LinkedList<BigInteger>();

	    if (n.compareTo(two) < 0)
	    {
	        throw new IllegalArgumentException("must be greater than one");
	    }

	    while (n.mod(two).equals(BigInteger.ZERO))
	    {
	        fs.add(two);
	        n = n.divide(two);
	    }

	    if (n.compareTo(BigInteger.ONE) > 0)
	    {
	        BigInteger f = BigInteger.valueOf(3);
	        
	        while (f.multiply(f).compareTo(n) <= 0)
	        {
	            if (n.mod(f).equals(BigInteger.ZERO))
	            {
	                fs.add(f);
	                n = n.divide(f);
	                fs.add(n);
	                //System.out.println("F: " + f);
	                break;
	            }
	            else
	            {
	                f = f.add(two);
	            }
	            counter++;
	        }
	        fs.add(n);
	    }
	    //System.out.println(counter);
	    return fs;
	}
}
