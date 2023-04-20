import java.util.*;
import java.io.*;

public class Main {
	static int[][][] distance;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		char[][] map = new char[N][M];
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		Node start = null;
		Node end = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') start = new Node(i, j);
				if (map[i][j] == 'F') end = new Node(i, j);
			}
		}
//		System.out.println(1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'g') {
					for (int k = 0; k < 4; k++) {
						int ni = i + dr[k];
						int nj = j + dc[k];
						if (inBnd(ni, nj) && map[ni][nj] == '.')
							map[ni][nj] = 'n';
					}
				}
			}
		}
//		for (char[] m : map) System.out.println(Arrays.toString(m));
//		System.out.println(2);
		
		distance = new int[N][M][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				distance[i][j][0] = Integer.MAX_VALUE;
				distance[i][j][1] = Integer.MAX_VALUE;
			}
		}
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.add(new Loc(start, 0, 0));
		
//		System.out.println(3);
		
		while (!pq.isEmpty()) {
			Loc cur = pq.poll();
//			System.out.println(cur.node.r+" "+cur.node.c);
			if (!visited[cur.node.r][cur.node.c] || isSmall(cur.node, cur.g, cur.gNext)) {
				visited[cur.node.r][cur.node.c]= true;
				distance[cur.node.r][cur.node.c][0] = cur.g;
				distance[cur.node.r][cur.node.c][1] = cur.gNext;
				
				for (int k = 0; k < 4; k++) {
					int nextG = cur.g;
					int nextGNext = cur.gNext;
					int nr = cur.node.r + dr[k];
					int nc = cur.node.c + dc[k];
					if (inBnd(nr, nc)) {
						if (map[nr][nc] == 'g') nextG++;
						if (map[nr][nc] == 'n') nextGNext++;
						pq.add(new Loc(new Node(nr, nc), nextG, nextGNext));
					}
				}
			}
		}
//		System.out.println(4);
		System.out.println(distance[end.r][end.c][0]+" "+distance[end.r][end.c][1]);
	}
	
	static class Node{
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Loc implements Comparable<Loc>{
		Node node;
		int g;
		int gNext;
		
		public Loc(Node node, int g, int gNext) {
			this.node = node;
			this.g = g;
			this.gNext = gNext;
		}
		
		@Override
		public int compareTo(Loc o) {
			if (this.g == o.g) return this.gNext - o.gNext;
			return this.g - o.g;
		}
	}
	
	private static boolean isSmall(Node node, int g, int gNext) {
		if (g < distance[node.r][node.c][0]) return true;
		else if (g == distance[node.r][node.c][0] && gNext < distance[node.r][node.c][1]) return true;
		return false;
	}
	
	private static boolean inBnd(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}