import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] dp = new int[N+1][N+1];
			int[] sum = new int[N+1];
			for (int i = 1; i <= N; i++) { 
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = arr[i] + sum[i-1];
//				dp[i][i] = arr[i];
			}
			
			for (int diff = 1; diff <= N; diff++) {
				for (int start = 1; start + diff <= N; start++) {
					int end = start+diff;
					dp[start][end] = Integer.MAX_VALUE;
					for (int mid = start; mid < end; mid++) {
						dp[start][end] = Math.min(dp[start][end], dp[start][mid]+dp[mid+1][end]+sum[end]-sum[start-1]);
					}
				}
			}
//			System.out.println(Arrays.toString(dp[1][N]));
			sb.append(dp[1][N]+"\n");
		}
		System.out.println(sb);
	}
}