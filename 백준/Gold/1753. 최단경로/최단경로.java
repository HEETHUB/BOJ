import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer VE = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(VE.nextToken());
		int E = Integer.parseInt(VE.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<edge>[] graph = new ArrayList[V+1];
		for (int i = 0; i <= V; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new edge(e, w));
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		pq.add(new edge(start, 0));
		
		while (!pq.isEmpty()) {
			edge cur = pq.poll();
			
			if (visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for (edge next : graph[cur.e]) {
				if (distance[next.e] > distance[cur.e] + next.w) {
					distance[next.e] = distance[cur.e] + next.w;
					pq.add(new edge(next.e, distance[next.e]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
//		System.out.println(Arrays.toString(distance));
		System.out.println(sb);
	}
	
	static class edge implements Comparable<edge>{
		int e;
		int w;
		
		public edge(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}
	}
}