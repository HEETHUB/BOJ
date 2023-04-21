import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N+1][N+1];
		int[][] from = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dist[i][j] = 100000001;
				if (i == j) dist[i][j] = 0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[s][e] = Math.min(dist[s][e], w);
			from[s][e] = s;
		}
		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (dist[s][e] > dist[s][k]+dist[k][e]) {
						dist[s][e] = dist[s][k]+dist[k][e];
						from[s][e] = from[k][e];
					}
				}
			}
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (dist[i][j] == 100000001)
					dist[i][j] = 0;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == 0) {
					sb.append("0\n");
					continue;
				}
				stack.add(j);
				int fr = i;
				int to = j;
				while (from[fr][to] != fr) {
					stack.add(from[fr][to]);
					to = from[i][to];
				}
				stack.add(i);
				sb.append(stack.size()+" ");
				while (!stack.isEmpty())
					sb.append(stack.pop()+" ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}