import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<edge> edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());
		
		edges = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer ABC = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(ABC.nextToken());
			int B = Integer.parseInt(ABC.nextToken());
			int C = Integer.parseInt(ABC.nextToken());
			edges.add(new edge(A, B, C));
		}
		
		long[] ans = bellman_ford(1);
		if (ans != null) {
			for (int i = 2; i <= N; i++) 
				sb.append(ans[i]+"\n");
		} else sb.append("-1\n");
		System.out.println(sb);
	}
	
	private static long[] bellman_ford(int start) {
		long[] dist = new long[N+1];
		for (int i = 0; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[start] = 0;
		
		for (int i = 0; i < N; i++) {
			for (edge e : edges) {
				if (dist[e.s] != Integer.MAX_VALUE && dist[e.d] > dist[e.s] + e.w) {
					if (i == N-1) return null;
					dist[e.d] = dist[e.s] + e.w;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
		}
		return dist;
	}
	
	static class edge{
		int s;
		int d;
		int w;
		
		public edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
}