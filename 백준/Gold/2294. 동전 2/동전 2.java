import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coin;
		int[] dp = new int[k+1];
		
		for (int i = 0; i <= k; i++)
			dp[i] = 10001;
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
			coin = sc.nextInt();
			for (int j = coin; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin]+1);
			}
		}
		
		if (dp[k] == 10001) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}