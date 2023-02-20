import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static LinkedList<node>[] tree;
	static boolean[] visited;
	static Queue<node> queue = new LinkedList<>();
	static int[] distance;
	static int max = 0;
	static int start = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		tree = new LinkedList[V+1];
		
		for (int i = 0; i <= V; i++)
			tree[i] = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			while (true) {
				int edge = Integer.parseInt(st.nextToken());
				if (edge == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				tree[vertex].add(new node(edge, dist));
				tree[edge].add(new node(vertex, dist));
			}
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		start = 1;
		bfs(start);
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		bfs(start);
		
		System.out.println(max);
	}

	private static void bfs(int num) {
		Queue<node> queue = new LinkedList<>();
		queue.offer(new node(num, 0));
		visited[num] = true;
		while (!queue.isEmpty()) {
			node curNode = queue.poll();
			for (node temp : tree[curNode.val]) {
				if (!visited[temp.val]) {
					queue.offer(temp);
					visited[temp.val] = true;
					distance[temp.val] = distance[curNode.val] + temp.dist;
					if (distance[temp.val] > max) {
						max = distance[temp.val];
						start = temp.val;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
	}

	static class node{
		int val;
		int dist;
		
		public node(int val, int dist) {
			this.val = val;
			this.dist = dist;
		}
		
	}
	
}