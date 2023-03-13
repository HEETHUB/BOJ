import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[][] map, dp;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(0, 0);
//		for (int[] d: dp) System.out.println(Arrays.toString(d));
		System.out.println(dp[0][0]);
	}
	private static int dfs(int r, int c) {
		if (r == N-1 && c == M-1) 
			return 1;
		
		if (dp[r][c] >= 0) return dp[r][c];
		
		dp[r][c] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && map[nr][nc] < map[r][c]) {
				dp[r][c] += dfs(nr, nc);
			}
		}
		
		return dp[r][c];
	}
	
	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}