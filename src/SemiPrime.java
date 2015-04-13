import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class SemiPrime {

	private static int n = 100;
	private static ArrayList<BigInteger> used = new ArrayList<BigInteger>();
	static PrintWriter writer;

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		int size = Integer.parseInt(args[0]);
		int type = Integer.parseInt(args[1]);
		if (type == 1) {
			String fileName = "PowerPrime" + size;
			writer = new PrintWriter(fileName, "UTF-8");
			generatePowers(size);
		} else if (type == 2) {
			String fileName = "SafeSameSize" + size;
			writer = new PrintWriter(fileName, "UTF-8");
			generateSafeSize(size);
		} else if (type == 3) {
			String fileName = "UnsafeSameSize" + size;
			writer = new PrintWriter(fileName, "UTF-8");
			generateUnsafeSize(size);
		} else {
			String fileName = "AssymetricalSize" + size;
			writer = new PrintWriter(fileName, "UTF-8");
			generateAssymetricalSize(size);
		}
		
		writer.close();
	}

	private static void generatePowers(int size) {
		int halfSize = size / 2;
		Random r = new Random();

		while (used.size() < n) {
			BigInteger b = BigInteger.probablePrime(halfSize, r);
			BigInteger primePower = b.multiply(b);

			if (primePower.bitLength() == size && !used.contains(primePower)) {
				used.add(primePower);
				// System.out.println(primePower);
				writer.println(primePower);
				System.out.println("Nr: " + used.size() + " PrimePower: "
						+ primePower + " Size: " + primePower.bitLength()
						+ " Prime 1: " + b + " Prime 1 size: " + b.bitLength()
						+ " Prime 2: " + b + " Prime 2 size: " + b.bitLength());

			}

		}

		System.out.println("I AM DONE MASTER LUDWIG");
	}

	private static void generateSafeSize(int size) {
		int primeSize1 = (size / 10) * 6;
		int primeSize2 = (size / 10) * 4;
		Random r = new Random();

		while (used.size() < n) {
			BigInteger p1 = BigInteger.probablePrime(primeSize1, r);
			BigInteger p2 = BigInteger.probablePrime(primeSize2, r);
			BigInteger semiPrime = p2.multiply(p1);

			if (semiPrime.bitLength() == size && !used.contains(semiPrime)) {
				used.add(semiPrime);
				writer.println(semiPrime);
				System.out.println("Nr: " + used.size() + " semiPrime: "
						+ semiPrime + " Size: " + semiPrime.bitLength()
						+ " Prime 1: " + p1 + " Prime 1 size: "
						+ p1.bitLength() + " Prime 2: " + p2
						+ " Prime 2 size: " + p2.bitLength());
			}
		}

		System.out.println("KLAR MÄSTARE LUDWIG");
	}

	private static void generateUnsafeSize(int size) {
		int primeSize = size / 2;
		Random r = new Random();

		while (used.size() < n) {
			BigInteger p1 = BigInteger.probablePrime(primeSize, r);
			BigInteger p2 = p1.nextProbablePrime();
			BigInteger semiPrime = p2.multiply(p1);

			if (semiPrime.bitLength() == size && !used.contains(semiPrime)) {
				used.add(semiPrime);
				writer.println(semiPrime);
				System.out.println("Nr: " + used.size() + " semiPrime: "
						+ semiPrime + " Size: " + semiPrime.bitLength()
						+ " Prime 1: " + p1 + " Prime 1 size: "
						+ p1.bitLength() + " Prime 2: " + p2
						+ " Prime 2 size: " + p2.bitLength());
			}
		}
		System.out.println("PLEASE MASTER LUDWIG I'M DONE!");
	}

	private static void generateAssymetricalSize(int size) {
		int primeSize1 = (size / 10) * 9;
		int primeSize2 = (size / 10) * 1;
		Random r = new Random();

		while (used.size() < n) {
			BigInteger p1 = BigInteger.probablePrime(primeSize1, r);
			BigInteger p2 = BigInteger.probablePrime(primeSize2, r);
			BigInteger semiPrime = p2.multiply(p1);

			if (semiPrime.bitLength() == size && !used.contains(semiPrime)) {
				used.add(semiPrime);
				writer.println(semiPrime);
				System.out.println("Nr: " + used.size() + " semiPrime: "
						+ semiPrime + " Size: " + semiPrime.bitLength()
						+ " Prime 1: " + p1 + " Prime 1 size: "
						+ p1.bitLength() + " Prime 2: " + p2
						+ " Prime 2 size: " + p2.bitLength());
			}
		}
		System.out.println("PLEASE MASTER LUDWIG I'M DONE! LEEEEEEE?!!?!?");
	}
}
