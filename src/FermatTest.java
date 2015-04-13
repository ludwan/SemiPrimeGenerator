import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

public class FermatTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(args[0])));
		try {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	long start = System.nanoTime();
		    	System.out.println("Factors: " + FermatFactor(new BigInteger(line)) + " Time: " + (System.nanoTime() - start));
		    }
		} finally {
		    br.close();
		}
		
		
		FermatFactor(new BigInteger(args[0]));
	}

	public static LinkedList<BigInteger> FermatFactor(BigInteger N) {
		
		BigInteger a = sqrt(N);
		BigInteger b2 = a.multiply(a).subtract(N);
		//System.out.println(N + " " + a + " " + b2);
		//System.out.println(isSquare(b2));
		while (!isSquare(b2)) {
			a = a.add(BigInteger.ONE);
			b2 = a.multiply(a).subtract(N);
			// System.out.println(N + " " + a + " " + b2);
		}

		//System.out.println(a + " " + b2);
		LinkedList<BigInteger> ll = new LinkedList<BigInteger>();
		BigInteger r1 = a.subtract(sqrt(b2));
		BigInteger r2 = N.divide(r1);
		ll.add(r1);
		ll.add(r2);
		return ll;
	}

	public static boolean isSquare(BigInteger N) {
		BigInteger sqr = sqrt(N);

		if (sqr.multiply(sqr).equals(N)
				|| (sqr.add(BigInteger.ONE)).multiply(sqr.add(BigInteger.ONE))
						.equals(N))
			return true;
		return false;
	}

	public static BigInteger bigIntSqRootFloor(BigInteger x)
			throws IllegalArgumentException {
		if (x.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalArgumentException("Negative argument.");
		}
		// square roots of 0 and 1 are trivial and
		// y == 0 will cause a divide-by-zero exception
		if (x.equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)) {
			return x;
		} // end if
		BigInteger two = BigInteger.valueOf(2L);
		BigInteger y;
		// starting with y = x / 2 avoids magnitude issues with x squared
		for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = ((x.divide(y))
				.add(y)).divide(two))
			;
		return y;
	} // end bigIntSqRootFloor

	public static BigInteger bigIntSqRootCeil(BigInteger x)
			throws IllegalArgumentException {
		if (x.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalArgumentException("Negative argument.");
		}
		// square roots of 0 and 1 are trivial and
		// y == 0 will cause a divide-by-zero exception
		if (x == BigInteger.ZERO || x == BigInteger.ONE) {
			return x;
		} // end if
		BigInteger two = BigInteger.valueOf(2L);
		BigInteger y;
		// starting with y = x / 2 avoids magnitude issues with x squared
		for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = ((x.divide(y))
				.add(y)).divide(two))
			;
		if (x.compareTo(y.multiply(y)) == 0) {
			return y;
		} else {
			return y.add(BigInteger.ONE);
		}

	}

	public static BigInteger sqrt(BigInteger x) throws IllegalArgumentException {
		if (x.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalArgumentException("Negative argument.");
		}
		// square roots of 0 and 1 are trivial and
		// y == 0 will cause a divide-by-zero exception
		if (x == BigInteger.ZERO || x == BigInteger.ONE) {
			return x;
		} // end if
		BigInteger two = BigInteger.valueOf(2L);
		BigInteger y;
		// starting with y = x / 2 avoids magnitude issues with x squared
		for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = ((x.divide(y))
				.add(y)).divide(two))
			;
		if (x.compareTo(y.multiply(y)) == 0) {
			return y;
		} else {
			return y.add(BigInteger.ONE);
		}
	}
}
