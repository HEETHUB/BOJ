import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[][] farm;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int k = 0; k < 4; k++) {
			int nr = r+dr[k];
			int nc = c+dc[k];
			if (nr>=0 && nr<N && nc>=0 && nc<M) {
				if (!visited[nr][nc]&&farm[nr][nc] == 1)
					dfs(nr,nc);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			farm = new int[N][M];
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				farm[r][c] = 1;
			}
			
			int ans = 0;
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j]==1 && !visited[i][j]) {
						dfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}