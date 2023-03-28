import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<edge> pq;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 1;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] > 0) bfs(i, j, idx++);
			}
		}
		
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					getBridge(i, j, map[i][j]);
				}
			}
		}

		arr = new int[idx];
		for (int i = 0; i < idx; i++)
			arr[i] = i;
		int ans = 0;
		while (!pq.isEmpty()) {
			edge cur = pq.poll();
			if (find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				ans += cur.w;
			}
		}
		if (isLinked()) System.out.println(ans);
		else System.out.println(-1);
	}
	
	private static boolean isLinked() {
		for (int i = 1; i < arr.length-1; i++) {
			if (find(i) != find(i+1)) return false;
		}
		return true;
	}
	private static int find(int a) {
		if (a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) arr[b] = a;
	}

	private static void getBridge(int r, int c, int idx) {
		for (int k = 0; k < 4; k++) {
			for (int i = 1; i < 10; i++) {
				int nr = r + dr[k]*i;
				int nc = c + dc[k]*i;
				if (!check(nr, nc)) break;
				else if (map[nr][nc] > 0) {
					if (map[nr][nc] == idx) break;
					else {
						if (i >= 3) pq.add(new edge(idx, map[nr][nc], i-1));
						break;
					}
				}
			}
		}
	}

	private static void bfs(int r, int c, int idx) {
		map[r][c] = idx;
		visited[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) 
				bfs(nr, nc, idx);
		}
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
	
	static class edge implements Comparable<edge>{
		int s;
		int e;
		int w;
		
		public edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}
	}
}