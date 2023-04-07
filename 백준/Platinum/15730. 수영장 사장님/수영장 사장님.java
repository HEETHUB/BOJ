import java.util.*;
import java.io.*;

public class Main {
	static int N, M; 
	static int[][] temp;
	public static void main(String[] args) throws Exception {
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		int[][] map = new int[N+2][M+2];
		int[][] temp = new int[N+2][M+2];
        
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = 10001;
			}
		}
		
		while (true) {
			boolean check = true;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (map[r][c] == temp[r][c]) continue;
					int min = 10001;
					
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if (check(nr, nc))
							min = Math.min(min, temp[nr][nc]);
					}
					
					if (temp[r][c] > min) {
						temp[r][c] = Math.max(map[r][c], min);
						check = false;
					}
				}
			}
			if (check) break;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				ans += temp[i][j] - map[i][j];
			}
		}
		
		System.out.println(ans);
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < N+2 && c >= 0 && c < M+2) return true;
		return false;
	}

	static class Node{
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}