import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<node>[] list = new ArrayList[N+1];
		ArrayList<node>[] list_rev = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			list_rev[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[N+1];
		int[] time = new int[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new node(e, v));
			list_rev[e].add(new node(s, v));
			inDegree[e]++;
		}
		StringTokenizer SE = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(SE.nextToken());
		int end = Integer.parseInt(SE.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (node l : list[cur]) {
				inDegree[l.u]--;
				time[l.u] = Math.max(time[l.u], time[cur]+l.v);
				if (inDegree[l.u] == 0) queue.add(l.u);
			}
		}
//		System.out.println(Arrays.toString(time));
		
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		visited[end] = true;
		queue.add(end);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (node l : list_rev[cur]) {
				if (time[l.u] == time[cur] - l.v) {
					cnt++;
					if (!visited[l.u]) {
						visited[l.u] = true;
						queue.add(l.u);
					}
				}
			}
		}
		
		System.out.println(time[end]);
		System.out.println(cnt);
	}
	
	static class node{
		int u;
		int v;
		public node(int u, int v) {
			this.u = u;
			this.v = v;
		}
		@Override
		public String toString() {
			return "[" + u + ", " + v + "]";
		}
	}
}