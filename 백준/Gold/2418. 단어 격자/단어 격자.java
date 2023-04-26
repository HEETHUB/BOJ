import java.util.*;
import java.io.*;

public class Main {
	static int H,W,L;
	static char[][] map;
	static char[] word;
//	static HashMap<Integer, Integer>[][] memory;
	static long[][][] dp;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		for (int i = 0; i < H; i++) 
			map[i] = br.readLine().toCharArray();
		word = br.readLine().toCharArray();
//		memory = new HashMap[H][W];
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				memory[i][j] = new HashMap<>();
//			}
//		}
		dp = new long[H][W][L];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				for (int k = 0; k < L; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		long ans = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == word[0]) {
					ans += find(i, j, 0);
				}
			}
		}
		System.out.println(ans);
	}

	private static long find(int r, int c, int idx) {
		dp[r][c][idx] = 0;
		if (idx == L-1) 
			return dp[r][c][L-1] = 1;
		for (int k = 0; k < 8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (inBnd(nr, nc) && map[nr][nc] == word[idx+1]) {
				if (dp[nr][nc][idx+1] >= 0) dp[r][c][idx] += dp[nr][nc][idx+1];
				else dp[r][c][idx] += find(nr,nc,idx+1);
			}
		}
		return dp[r][c][idx];
	}
	
	private static boolean inBnd(int r, int c) {
		if (r < 0 || r >= H || c < 0 || c >= W) return false;
		return true;
	}
}