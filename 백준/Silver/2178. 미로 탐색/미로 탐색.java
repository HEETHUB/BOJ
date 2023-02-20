import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] maze;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
	
		for (int i = 0; i < N; i++) {
			String m = br.readLine();
			for (int j = 0; j < M; j++)
				maze[i][j] = m.charAt(j) - '0';
		}
		
		bfs(0, 0, 1);
		
		System.out.println(maze[N-1][M-1]);
	}

	private static void bfs(int i, int j, int depth) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		queue.offer(j);
		
		while (!queue.isEmpty()) {
			int r = queue.poll(); 
			int c = queue.poll();
			
			if (r == N-1 && c == M-1) {
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (maze[nr][nc] == 1) {
						queue.offer(nr);
						queue.offer(nc);
						maze[nr][nc] = maze[r][c] + 1;
					}
				}
			}
		}
	}
}