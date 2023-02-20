import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr[num1].add(num2);
			arr[num2].add(num1);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 1);
            if (ans == 1) break;
		}
		System.out.println(ans);
	}
	
	private static void dfs(int num, int depth) {
		visited[num] = true;
		if (depth == 5) {
			ans = 1;
			return;
		}
		for (int i = 0; i < arr[num].size(); i++) {
			int next = arr[num].get(i);
			if (!visited[next]) {
				dfs(next, depth+1);
				visited[next] = false;
			}
		}
	}
}