import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Planet[] planets;
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		planets = new Planet[N];
		parent = new int[N+1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			long z = Long.parseLong(st.nextToken());
			planets[i] = new Planet(i+1, x, y, z);
		}
		
		pq = new PriorityQueue<>();
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				if (o1.x < o2.x) return -1;
				return 1;
			}
		});
		for (int i = 0; i < N-1; i++)
			pq.add(new Edge(planets[i].num, planets[i+1].num, getDistance(planets[i], planets[i+1])));
		
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				if (o1.y < o2.y) return -1;
				return 1;
			}
		});
		for (int i = 0; i < N-1; i++)
			pq.add(new Edge(planets[i].num, planets[i+1].num, getDistance(planets[i], planets[i+1])));
		
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				if (o1.z < o2.z) return -1;
				return 1;
			}
		});
		for (int i = 0; i < N-1; i++)
			pq.add(new Edge(planets[i].num, planets[i+1].num, getDistance(planets[i], planets[i+1])));
		
		long ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				ans += edge.w;
			}
		}
		
		System.out.println(ans);
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
	
	private static long getDistance(Planet p1, Planet p2) {
		return Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z-p2.z)));
	}
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		long w;
		
		public Edge(int s, int e, long w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.w < o.w) return -1;
			return 1;
		}

		@Override
		public String toString() {
			return "Edge [" + s + ", " + e + ", " + w + "]";
		}
	}
	
	static class Planet{
		int num;
		long x;
		long y;
		long z;
		
		public Planet(int num, long x, long y, long z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}