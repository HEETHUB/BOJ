import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) 
			graph[i] = new ArrayList<>();
		
		int[] time = new int[N+1];
		int[] inDegree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			time[i] = T;
			int M = Integer.parseInt(st.nextToken());
			for (int m = 0; m < M; m++) {
				int E = Integer.parseInt(st.nextToken());
				graph[E].add(i);
				inDegree[i]++;
			}
		}
//		System.out.println(Arrays.toString(inDegree));
		int[] ans = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			ans[cur] += time[cur];
			for (int next : graph[cur]) {
				if (!visited[next]) {
					ans[next] = Math.max(ans[next], ans[cur]);
					inDegree[next]--;
					if (inDegree[next] == 0) queue.add(next);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, ans[i]);
		
//		System.out.println(Arrays.toString(ans));
		System.out.println(max);
	}
}