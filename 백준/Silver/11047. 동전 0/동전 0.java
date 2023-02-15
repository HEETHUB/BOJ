import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] dp = new int[K+1];
		int coin = 0;
		
		for (int i = 1; i <= K; i++)
			dp[i] = 100000001;
		
		for (int i = 0; i < N; i++) {
			coin = sc.nextInt();
			for (int j = coin; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin]+1);
			}
		}
		System.out.println(dp[K]);
	}
}