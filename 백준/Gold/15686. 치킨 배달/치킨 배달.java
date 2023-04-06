import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans, sum;
	static int[][] map;
	static ArrayList<Node> chickens, houses;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		map = new int[N][N];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) chickens.add(new Node(i, j));
				else if (map[i][j] == 1) houses.add(new Node(i, j));
			}
		}
		int cSize = chickens.size();
		arr = new int[M];
		ans = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(ans);
	}
	
	private static void combination(int idx, int k) {
		if (idx == M) {
			ans = Math.min(ans, getDistSum());
			return;
		}
		for (int i = k; i < chickens.size(); i++) {
			arr[idx] = i;
			combination(idx+1, i+1);
		}
	}

	private static int getDistSum() {
		int res = 0;
		for (Node h : houses) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) 
				min = Math.min(min, getDistance(h, chickens.get(arr[i])));
			res += min;
		}
		return res;
	}

	private static int getDistance(Node n1, Node n2) {
		return Math.abs(n1.r - n2.r) + Math.abs(n1.c - n2.c);
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