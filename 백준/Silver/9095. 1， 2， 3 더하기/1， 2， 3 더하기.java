import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] dp = new int[n+3];
			dp[2] = 1;
			for (int i = 3; i <= n+2; i++) {
				dp[i] += dp[i-1] + dp[i-2] + dp[i-3];
			}
			sb.append(dp[n+2]+"\n");
		}
		System.out.println(sb);
	}
}