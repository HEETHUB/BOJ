import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph[S].add(E);
			inDegree[E]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		int cnt = 0;
		int[] ans = new int[N+1];
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				ans[cur] = cnt;
				if (visited[cur]) continue;
				visited[cur] = true;
				for (int next : graph[cur]) {
					if (!visited[next]) {
						inDegree[next]--;
						if (inDegree[next] == 0) queue.add(next);
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++)
			sb.append(ans[i]+" ");
		
		System.out.println(sb);
		
	}
}