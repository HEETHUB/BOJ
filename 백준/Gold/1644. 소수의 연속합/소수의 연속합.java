import java.util.*;
import java.io.*;

public class Main {
	static int N, size;
	static int[] prime, primeSum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new int[N+1];
		primeSum = new int[N+1];
		makePrime();
		int ans = 0;
		int left = 0;
		int right = 1;
		while (right < size) {
			int sum = primeSum[right] - primeSum[left];
			if (sum == N) {
				ans++;
				right++;
			} else if (sum > N) left++;
			else right++;
		}
		System.out.println(ans);
	}
	
	private static void makePrime() {
		for (int i = 0; i <= N; i++)
			prime[i] = i;
		prime[1] = 0;
		for (int i = 2; i*i <= N; i++) {
			for (int j = i*2; j <= N; j += i) {
				prime[j] = 0;
			}
		}

		size = 1;
		for (int i = 2; i <= N; i++) {
			if (prime[i] != 0) {
				primeSum[size] = prime[i];
				primeSum[size] += primeSum[size-1];
				size++;
			}
		}
		primeSum = Arrays.copyOfRange(primeSum, 0, size);
	}
}