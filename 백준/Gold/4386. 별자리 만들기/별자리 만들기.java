import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parent;
	static double[][] planets;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		planets = new double[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			planets[i][0] = Double.parseDouble(st.nextToken());
			planets[i][1] = Double.parseDouble(st.nextToken());
		}
		
		pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				pq.add(new Edge(i, j, getDistance(planets[i], planets[j])));
			}
		}
		
		double ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				ans += edge.w;
			}
		}
		System.out.println(String.format("%.2f", ans));
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) parent[b] =a;
	}

	private static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	private static double getDistance(double[] p1, double[] p2) {
		return Math.sqrt(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2));
	}

	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		double w;
		
		public Edge(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.w < o.w) return -1;
			return 1;
		}
	}
	
	static class Planet{
		double x;
		double y;
		
		public Planet(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}