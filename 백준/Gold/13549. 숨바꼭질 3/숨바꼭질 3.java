import java.io.*;
import java.util.*;

public class Main {
	static int N, K, ans;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NK.nextToken());
		K = Integer.parseInt(NK.nextToken());
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		int[] visited = new int[100001];
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(N, 1));
		while (!queue.isEmpty()) {
			node cur = queue.poll();
			if (cur.num+1 <= 100000) {
				if (visited[cur.num+1] == 0 || visited[cur.num+1] > cur.time+1) {
					visited[cur.num+1] = cur.time+1;
					queue.add(new node(cur.num+1, cur.time+1));
				}
			}
			
			if (cur.num-1 >= 0) {
				if (visited[cur.num-1] == 0 || visited[cur.num-1] > cur.time+1) {
					visited[cur.num-1] = cur.time+1;
					queue.add(new node(cur.num-1, cur.time+1));
				}
			}
				
			if (cur.num*2 > 0 && cur.num*2 <= 100000) {
				if (visited[cur.num*2] == 0 || visited[cur.num*2] > cur.time) {
					visited[cur.num*2] = cur.time;
					queue.add(new node(cur.num*2, cur.time));
				}
			}
		}
		System.out.println(visited[K]-1);
	}
	
	static class node{
		int num;
		int time;
		public node(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
}