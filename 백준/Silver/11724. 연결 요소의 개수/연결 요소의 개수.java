import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static Map<Integer, Set<Integer>> map = new HashMap<>();
	static Stack<Integer> stack = new Stack<>();
	static int ans = 0;
	
	public static void dfs(int n) {
		if (visited[n])
			return;
		stack.add(n);
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				visited[node] = true;
				for (int i : map.get(node)) 
					stack.add(i);
			}
		}
		ans++;
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++)
			map.put(i, new HashSet<>());
		
		for (int i = 0; i < M; i++) {	
			Integer x = sc.nextInt();
			Integer y = sc.nextInt();
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		for (int i = 1; i <= N; i++)
			dfs(i);
		
		System.out.println(ans);
	}
}
