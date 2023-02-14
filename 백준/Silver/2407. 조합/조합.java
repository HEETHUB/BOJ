import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger[][] cache = new BigInteger[101][101];  
	
	public static BigInteger combi(int n, int r) {
		if (r == 0 || n == r) {
			cache[n][r] = BigInteger.ONE;
			return BigInteger.ONE;
		}
		if (cache[n][r] != null)
			return cache[n][r];
		cache[n][r] = combi(n-1, r-1).add(combi(n-1, r));
		return cache[n][r];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(combi(n, m));
	}
}