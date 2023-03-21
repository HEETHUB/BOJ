import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer nmk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(nmk.nextToken());
		int M = Integer.parseInt(nmk.nextToken());
		int K = Integer.parseInt(nmk.nextToken());
		
		PriorityQueue<Integer>[] dist = new PriorityQueue[N+1];
		
		for (int i = 0; i <= N; i++) 
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		
		ArrayList<node>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer suv = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(suv.nextToken());
			int u = Integer.parseInt(suv.nextToken());
			int v = Integer.parseInt(suv.nextToken());
			graph[s].add(new node(u, v));
		}
		
		int start = 1;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start, 0));
		dist[start].add(0);
		
		while (!pq.isEmpty()) {
			node cur = pq.poll();
			
			for (node next : graph[cur.u]) {
				int qSize = dist[next.u].size();
				if (qSize < K || (qSize == K && dist[next.u].peek() > cur.v + next.v)) {
					if (qSize == K) dist[next.u].poll();
					dist[next.u].add(cur.v+next.v);
					pq.add(new node(next.u, cur.v + next.v));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int ans = -1;
			if (dist[i].size() == K) ans = dist[i].poll();
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static class node implements Comparable<node>{
		int u;
		int v;
		public node(int u, int v) {
			this.u = u;
			this.v = v;
		}
		
		@Override
		public int compareTo(node o) {
			return this.v - o.v;
		}
	}
}