import java.io.*;
import java.util.*;

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer MNH = new StringTokenizer(br.readLine());
		M = Integer.parseInt(MNH.nextToken());
		N = Integer.parseInt(MNH.nextToken());
		H = Integer.parseInt(MNH.nextToken());
		
		box = new int[H][N][M];
		queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == 1) queue.add(new int[] {h, n, m});
				}
			}
		}
		
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		int ans = -1;
		int[] dh = {0,0,0,0,1,-1};
		int[] dr = {0,0,1,-1,0,0};
		int[] dc = {1,-1,0,0,0,0};
		while (!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] node = queue.poll();
				for (int k = 0; k < 6; k++) {
					int nh = node[0] + dh[k];
					int nr = node[1] + dr[k];
					int nc = node[2] + dc[k];
					if (check(nh, nr, nc) && box[nh][nr][nc] == 0) {
						box[nh][nr][nc] = 1;
						queue.add(new int[] {nh, nr, nc});
					}
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0)
						ans = -1;
				}
			}
		}
		
		return ans;
	}

	private static boolean check(int nh, int nn, int nm) {
		if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) return true;
		return false;
	}
}