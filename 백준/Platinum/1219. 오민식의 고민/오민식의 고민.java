import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<edge> edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new edge(s, d, w));
		}
		
		long[] earn = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			earn[i] = Long.parseLong(st.nextToken());
		
		long[] dist = new long[N];
		for (int i = 0; i < N; i++)
			dist[i] = Long.MIN_VALUE;
		dist[S] = earn[S];
		for (int i = 0; i < N+100; i++) {
			for (edge e : edges) {
				if (dist[e.S] == Long.MIN_VALUE) continue;
				if (dist[e.S] == Long.MAX_VALUE) dist[e.D] = Long.MAX_VALUE;
				if (dist[e.D] < dist[e.S] - e.W + earn[e.D]) {
					dist[e.D] = dist[e.S] - e.W + earn[e.D];
					if (i >= N - 1) dist[e.D] = Long.MAX_VALUE;
				}
			}
		}
		if (dist[E] == Long.MIN_VALUE) System.out.println("gg");
		else if (dist[E] == Long.MAX_VALUE) System.out.println("Gee");
		else System.out.println(dist[E]);
	}
	
	static class edge{
		int S;
		int D;
		int W;
		public edge(int s, int d, int w) {
			this.S = s;
			this.D = d;
			this.W = w;
		}
	}
}