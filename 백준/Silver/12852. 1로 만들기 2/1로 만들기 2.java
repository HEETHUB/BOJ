import java.util.Arrays;
//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static node[] dp;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		dp = new node[N+1];
		for (int i = 0; i <= N; i++)
			dp[i] = new node(Integer.MAX_VALUE, N+1);
		dp[N].cnt = 0;
		dp[N].next = N+1;
		for (int i = N-1; i >= 1; i--) {
			dp[i].cnt = dp[i+1].cnt+1;
			dp[i].next = i+1;
			if (i*2 <= N && dp[i].cnt > dp[2*i].cnt+1) {
				dp[i].cnt = dp[2*i].cnt+1;
				dp[i].next = 2*i;
			}
			if (i*3 <= N && dp[i].cnt > dp[3*i].cnt+1) {
				dp[i].cnt = dp[3*i].cnt+1;
				dp[i].next = 3*i;
			}
		}
		sb.append(dp[1].cnt+"\n");
		int[] ans = new int[dp[1].cnt+1];
		ans[0] = 1;
		int idx = 1;
		int cur = 1;
		while (idx < ans.length) {
			ans[idx++] = dp[cur].next;
			cur = dp[cur].next;
		}
		for (int i = ans.length-1; i >= 0; i--) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
	}
	
	static class node{
		int cnt;
		int next;
		public node(int cnt, int next) {
			this.cnt = cnt;
			this.next = next;
		}
	}
}