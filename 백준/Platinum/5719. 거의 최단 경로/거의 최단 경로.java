import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while (true) {
			cnt++;
			StringTokenizer NM = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(NM.nextToken());
			int M = Integer.parseInt(NM.nextToken());
			if (N == 0 && M == 0) break;
			StringTokenizer SD = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(SD.nextToken());
			int D = Integer.parseInt(SD.nextToken());
			
			ArrayList<edge>[] edges = new ArrayList[N];
			ArrayList<edge>[] edges_rev = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				edges[i] = new ArrayList<>();
				edges_rev[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[s].add(new edge(d, w));
				edges_rev[d].add(new edge(s, w));
			}
			
			int[] dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[S] = 0;
			PriorityQueue<edge> pq = new PriorityQueue<>();
			pq.add(new edge(S, 0));
			boolean[] visited = new boolean[N+1];
			while (!pq.isEmpty()) {
				edge cur = pq.poll();
				if (visited[cur.d]) continue;
				visited[cur.d] = true;
				
				for (edge next : edges[cur.d]) {
					if (dist[next.d] > dist[cur.d] + next.w) {
						dist[next.d] = dist[cur.d] + next.w;
						pq.add(new edge(next.d, dist[next.d]));
					}
				}
			}
			
			int[] dist_rev = new int[N];
			Arrays.fill(dist_rev, Integer.MAX_VALUE);
			dist_rev[D] = 0;
			pq = new PriorityQueue<>();
			pq.add(new edge(D, 0));
			visited = new boolean[N+1];
			while (!pq.isEmpty()) {
				edge cur = pq.poll();
				if (visited[cur.d]) continue;
				visited[cur.d] = true;
				
				for (edge next : edges_rev[cur.d]) {
					if (dist_rev[next.d] > dist_rev[cur.d] + next.w) {
						dist_rev[next.d] = dist_rev[cur.d] + next.w;
						pq.add(new edge(next.d, dist_rev[next.d]));
					}
				}
			}
			
			int[] dist2 = new int[N];
			Arrays.fill(dist2, Integer.MAX_VALUE);
			dist2[S] = 0;
			visited = new boolean[N+1];
			pq.add(new edge(S, 0));
			while (!pq.isEmpty()) {
				edge cur = pq.poll();
				if (visited[cur.d]) continue;
				visited[cur.d] = true;
				
				for (edge next : edges[cur.d]) {
					if (dist[D] - dist[cur.d] - dist_rev[next.d] == next.w) {
						continue;
					}
					if (dist2[next.d] > dist2[cur.d] + next.w) {
						dist2[next.d] = dist2[cur.d] + next.w;
						pq.add(new edge(next.d, dist2[next.d]));
					}
				}
			}
			int ans = dist2[D];
			if (ans == Integer.MAX_VALUE) ans = -1;
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static class edge implements Comparable<edge>{
		int d;
		int w;
		
		public edge(int d, int w) {
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "edge [d=" + d + ", w=" + w + "]";
		}
	}
}