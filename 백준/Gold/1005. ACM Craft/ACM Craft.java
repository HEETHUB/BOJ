import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer NK = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(NK.nextToken());
			int K = Integer.parseInt(NK.nextToken());
			int[] times = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				times[i] = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[N+1];
			for (int i = 0; i <= N; i++)
				graph[i] = new ArrayList<>();
			int[] inDegree = new int[N+1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				inDegree[e]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) queue.add(i);
			}
			
			int[] ans = new int[N+1];
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				ans[cur] += times[cur];
				
				for (int next : graph[cur]) {
					ans[next] = Math.max(ans[next], ans[cur]);
					inDegree[next]--;
					if (inDegree[next] == 0) queue.add(next);
				}
			}
			sb.append(ans[W]+"\n");
		}
		System.out.println(sb);
	}
}