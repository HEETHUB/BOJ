import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
//	static ArrayList<Node> keys, doors;
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		map = new char[N][M];
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		Node start = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') start = new Node(i, j, 0);
			}
		}
		int idx = 0;
		visited = new boolean[N][M][64];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
//		int ans = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int key = checkKeys(cur.keys);
//			System.out.println(cur.r + " "+ cur.c+" "+Arrays.toString(cur.keys));
			for (int k = 0; k < 4; k++) {
				int nr = cur.r + dr[k];
				int nc = cur.c + dc[k];
				if (check(nr, nc) && map[nr][nc] != '#' && !visited[nr][nc][key]) {
//					System.out.println("통과");
//					System.out.println("---"+nr+" "+nc+" "+Arrays.toString(cur.keys)+" "+Arrays.toString(visited[cur.r][cur.c]));
					if (map[nr][nc] == '1') {
						System.out.println(cur.cnt+1);
						return;
					}
					if (map[nr][nc] == '0' || map[nr][nc] == '.'){
						Node next = new Node(nr, nc, cur.cnt+1);
						next.keys = Arrays.copyOfRange(cur.keys, 0, 6);
						visited[nr][nc][key] = true;
						queue.add(next);
					} else {
						if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
//							System.out.println("장애물" + nr+" "+nc+" "+Arrays.toString(cur.keys));
							if (cur.keys[map[nr][nc] - 'A'] > 0) {
//								System.out.println("장애물 통과!");
								Node next = new Node(nr, nc, cur.cnt+1);
								next.keys = Arrays.copyOfRange(cur.keys, 0, 6);
								queue.add(next);
								visited[nr][nc][key] = true;
							}
						} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
							Node next = new Node(nr, nc, cur.cnt+1);
							next.keys = Arrays.copyOfRange(cur.keys, 0, 6);
							next.keys[map[nr][nc]-'a'] = 1;
							visited[nr][nc][key] = true;
							queue.add(next);
						}
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