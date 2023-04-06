import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];
		
		Node start = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') start = new Node(i, j, 0);
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int keyIdx = checkKeys(cur.keys);
			
			for (int k = 0; k < 4; k++) {
				int nr = cur.r + dr[k];
				int nc = cur.c + dc[k];
				if (check(nr, nc) && map[nr][nc] != '#' && !visited[nr][nc][keyIdx]) {
					Node next = new Node(nr, nc, cur.cnt+1);
					next.keys = Arrays.copyOfRange(cur.keys, 0, 6);
					if (map[nr][nc] == '1') {
						System.out.println(cur.cnt+1);
						return;
					}
					else if (map[nr][nc] == '0' || map[nr][nc] == '.'){
						visited[nr][nc][keyIdx] = true;
						queue.add(next);
					} 
					else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F'){
						if (cur.keys[map[nr][nc] - 'A'] > 0) {
							visited[nr][nc][keyIdx] = true;
							queue.add(next);
						}
					} 
					else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						next.keys[map[nr][nc]-'a'] = 1;
						visited[nr][nc][keyIdx] = true;
						queue.add(next);
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
	
	static class Node {
		int r;
		int c;
		int cnt;
		int[] keys = new int[6];
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int checkKeys(int[] arr) {
		int ans = 0;
		for (int i = 0; i < 6; i++) 
			ans += Math.pow(2, i)*arr[i];
		return ans;
	}
}