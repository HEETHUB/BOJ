import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer VE = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(VE.nextToken());
		int E = Integer.parseInt(VE.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<node>[] graph = new ArrayList[V+1];
		
		for (int i = 0; i < V+1; i++) 
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new node(v, w));
		}
		
		int[] distance = new int[V+1];
		for (int i = 0; i <= V; i++)
			distance[i] = Integer.MAX_VALUE;
		
		distance[start] = 0;
		
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.w - o2.w;
			} 
		});
		
		boolean[] visited = new boolean[V+1];
//		visited[start] = true;
		pq.add(new node(start, 0));
		while (!pq.isEmpty()) {
			node cur = pq.poll();
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			for (node next : graph[cur.v]) {
				if (distance[next.v] > distance[cur.v] + next.w) {
//					visited[next.v] = true;
					distance[next.v] = distance[cur.v] + next.w;
					pq.add(new node(next.v, distance[next.v]));
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if (!visited[i]) System.out.println("INF");
			else System.out.println(distance[i]);
		}
		System.out.println(sb);
	}
}

class node{
	int v;
	int w;
	public node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}