import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static int N,M,K,X;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NMKX = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NMKX.nextToken());
		M = Integer.parseInt(NMKX.nextToken());
		K = Integer.parseInt(NMKX.nextToken());
		X = Integer.parseInt(NMKX.nextToken());
		
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
		}
		
//		for (ArrayList<Integer> a : arr) System.out.println(a);
		visited = new int[N+1];
		for (int i = 0; i <= N; i++)
			visited[i] = -1;
		bfs(X);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				list.add(i);
			}
		}
		
		if (list.isEmpty()) System.out.println("-1");
		else {
			for (int n : list) System.out.println(n);
		}
	}
	
	private static void bfs(int now) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(now);
		visited[now] = 0;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : arr[node]) {
				if (visited[i] == -1) {
					visited[i] = visited[node] + 1;
					queue.add(i);
				}
			}
		}
	}
}