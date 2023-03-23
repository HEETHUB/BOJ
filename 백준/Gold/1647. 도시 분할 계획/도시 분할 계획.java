import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		arr = new int[N+1];
		for (int i = 0; i <= N; i++)
			arr[i] = i;
		PriorityQueue<edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new edge(s, e, w));
		}
		int cnt = 0;
		int ans = 0;
		while (cnt < N-2) {
			edge cur = pq.poll();
			if (find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				ans += cur.w;
				cnt++;
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
			super();
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