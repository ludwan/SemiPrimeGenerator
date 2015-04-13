import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class PrimePower {

	private static int n = 100;
	private static ArrayList<BigInteger> used = new ArrayList<BigInteger>();
	public static void main(String[] args){
		int size = Integer.parseInt(args[0]);
		generatePowers(size);
	}

	private static void generatePowers(int size) {
		int halfSize = size/2;
		Random r = new Random();
		
		while(used.size() < n){
		BigInteger b = BigInteger.probablePrime(halfSize, r);
		BigInteger primePower = b.multiply(b);
		if(primePower.bitLength() == size && !used.contains(primePower)){
			used.add(primePower);
			//System.out.println(primePower);
			System.out.println("Nr: " + used.size() + " PrimePower: " + primePower + " Size: " + primePower.bitLength() + " Prime 1: " + b + " Prime 2: " + b);
			
		}
		
		
		
		}
		
		System.out.println("I AM DONE MASTER LUDWIG");
	}
}
