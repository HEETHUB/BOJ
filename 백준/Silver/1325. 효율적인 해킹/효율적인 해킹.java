import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NM.nextToken());
		M = Integer.parseInt(NM.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[to].add(from);
		}

		ans = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, ans[i]);

		for (int i = 1; i <= N; i++) {
			if (ans[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb);
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int to : arr[node]) {
				if (!visited[to]) {
					visited[to] = true;
					ans[num]++;
					queue.add(to);
				}
			}
		}
	}
}