import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Map<int[], Integer> next;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		int[][] sea = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = cntMnt(sea, 0);
		System.out.println(ans);
	}

	private static int cntMnt(int[][] sea, int cnt) {
		int ans = 0;
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		next = new HashMap<>();
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sea[i][j] > 0 && !visited[i][j]) {
					ans++;
					if (ans >= 2) return cnt;
					visited[i][j] = true;
					queue.add(new int[] {i, j});
					while (!queue.isEmpty()) {
						int[] node = queue.poll();
						next.put(node, 0);
						for (int k = 0; k < 4; k++) {
							int nr = node[0]+dr[k];
							int nc = node[1]+dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
								if (!visited[nr][nc] && sea[nr][nc] > 0) {
									visited[nr][nc] = true;
									queue.add(new int[] {nr, nc});
								}
								if (sea[nr][nc] == 0) next.put(node, next.get(node) + 1);
							}
						}
					}
				}
			}
		}
		if (next.isEmpty()) return 0;
		for (int[] n : next.keySet()) {
			sea[n[0]][n[1]] -= next.get(n);
			if (sea[n[0]][n[1]] < 0) sea[n[0]][n[1]] = 0;
		}
		return cntMnt(sea, cnt+1);
	}
}