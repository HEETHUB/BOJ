import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr;
	static int ans = 0;
//	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		visited = new boolean[N];
//		int ans = 1;
		
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
			dfs(i, 1, new boolean[N]);
            if (ans == 1) break;
		}
		System.out.println(ans);
	}

	private static void dfs1(int num, int depth, boolean[] visited) {
		if (depth == 5) ans++;
		Stack<Integer> stack = new Stack<>();
		stack.push(num);
		
		while (true) {
			Integer node = stack.pop();
			visited[node] = true;
			for (int i = 0; i < arr[node].size(); i++) {
				if (!visited[arr[node].get(i)]) {
					stack.push(arr[node].get(i));						break;
				}
			}
		}
	}
	
	private static void dfs(int num, int depth, boolean[] visited) {
		if (depth == 5) {
			visited[num] = true;
			ans = 1;
//			System.out.println(Arrays.toString(visited));
			return;
		}
		visited[num] = true;
	
		for (int i = 0; i < arr[num].size(); i++) {
			int next = arr[num].get(i);
			if (!visited[next]) {
//				System.out.println(Arrays.toString(visited));
//					visited[next] = true;
				dfs(next, depth+1, visited);
				visited[next] = false;
			}
		}
	}
}