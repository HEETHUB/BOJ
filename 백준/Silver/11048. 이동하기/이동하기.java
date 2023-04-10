import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		
		int[][] map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
			}
		}
		System.out.println(dp[N][M]);
	}
}