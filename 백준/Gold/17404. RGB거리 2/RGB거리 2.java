import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1000*N;
		for (int i = 0; i < 3; i++) {
			int[][] dp = new int[N][3];
			for (int x = 0; x < N; x++) 
				Arrays.fill(dp[x], 1000);
			
			dp[0][i] = RGB[0][i];
			for (int j = 1; j < N; j++) {
				dp[j][0] = RGB[j][0] + Math.min(dp[j-1][1], dp[j-1][2]);
				dp[j][1] = RGB[j][1] + Math.min(dp[j-1][0], dp[j-1][2]);
				dp[j][2] = RGB[j][2] + Math.min(dp[j-1][0], dp[j-1][1]);
			}
			for (int k = 0; k < 3; k++) {
				if (i == k) continue;
				ans = Math.min(ans, dp[N-1][k]);
			}
		}
		System.out.println(ans);
	}
}