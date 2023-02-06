import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coin;
		int[] dp = new int[k+1];
		dp[0] = 1;
		int[] dpCnt = new int[k+1];
		
		for (int i = 1; i < n+1; i++) {
			coin = sc.nextInt();
			for (int j = coin+1; j <= k; j++) {
				dp[coin] = 1;
				dpCnt[coin] = 1;
				dp[j] += dp[j - coin];
				if (dp[j] != 0) {
					if (dpCnt[j] > 0 && dpCnt[j] < dpCnt[j-coin]+1)
						continue;
					if (dpCnt[j-coin] > 0)
						dpCnt[j] = dpCnt[j-coin]+1;
				}
			}
		}
		if (dpCnt[k] > 0)
			System.out.println(dpCnt[k]);
		else System.out.println(-1);
		
	}
}