import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer VE = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(VE.nextToken());
		int E = Integer.parseInt(VE.nextToken());
		arr = new int[V+1];
		for (int i = 0; i <= V; i++)
			arr[i] = i;
		PriorityQueue<edge> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new edge(s, e, w));
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			edge cur = pq.poll();
			if (find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				ans += cur.w;
			}
		}
		System.out.println(ans);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) arr[b] = a;
	}
	
	private static int find(int a) {
		if (a == arr[a]) return a;
		return arr[a] = find(arr[a]);
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