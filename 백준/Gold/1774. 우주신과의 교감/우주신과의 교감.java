import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;
	static double[][] gods;
	static PriorityQueue<edge> edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		gods = new double[N+1][2];
		parent = new int[N+1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;
		int idx = 1;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gods[i][0] = Double.parseDouble(st.nextToken());
			gods[i][1] = Double.parseDouble(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			union(s, e);
		}
		
		edges = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				if (find(i) != find(j)) {
					edges.add(new edge(i, j, getDistance(gods[i], gods[j])));
				}
			}
		}
		
		double ans = 0;
		while (!edges.isEmpty()) {
			edge cur = edges.poll();
			
			if (find(cur.s) != find(cur.e)) {
				ans += cur.w;
				union(cur.s, cur.e);
			}
		}
		System.out.println(String.format("%.2f", ans));
	}
	
	private static double getDistance(double[] g1, double[] g2) {
		return Math.sqrt(Math.pow(g1[0] - g2[0], 2) + Math.pow(g1[1] - g2[1], 2));
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) parent[b] = a;
	}

	private static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	static class edge implements Comparable<edge>{
		int s;
		int e;
		double w;
		
		public edge(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			if (this.w < o.w) return -1;
			return 1;
		}		
	}
}