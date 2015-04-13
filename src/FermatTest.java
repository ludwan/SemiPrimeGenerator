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

	
	public static BigInteger sqrt(BigInteger n) {
		BigInteger r = BigInteger.ZERO;
		BigInteger m = r.setBit(2 * n.bitLength());
		BigInteger nr;

		do {
			nr = r.add(m);
			if (nr.compareTo(n) != 1) {
				n = n.subtract(nr);
				r = nr.add(m);
			}
			r = r.shiftRight(1);
			m = m.shiftRight(2);
		} while (m.bitCount() != 0);

		return r;
	}
}
