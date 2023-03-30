import java.io.*;
import java.util.*;

public class Main {
	static int N, ans, del;
	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N];
		for (int i = 0; i < N; i++)
			edges[i] = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent != -1) {
				edges[parent].add(i);
				edges[i].add(parent);
			}
			else root = i;
		}
		del = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		if (root == del) {
			System.out.println(0);
			return;
		}
		dfs(root);
		System.out.println(ans);
	}
	
	private static void dfs(int node) {
		visited[node] = true;
		int cntChild = 0;
		for (int child : edges[node]) {
			if (!visited[child] && child != del) {
				cntChild++;
				dfs(child);
			}
		}
		if (cntChild == 0) ans++;
	}
}