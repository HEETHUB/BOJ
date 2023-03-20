import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		

		int[] ans = new int[N];
		PriorityQueue<node> pq = new PriorityQueue<>();
		for (int i = N-1; i >= 0; i--) {
			while (!pq.isEmpty()) {
				if (arr[i] >= pq.peek().height)
					ans[pq.poll().idx] = i+1;
				else break;
			}
			pq.add(new node(i, arr[i]));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(ans[i]+" ");
		System.out.println(sb);
	}
	
	static class node implements Comparable<node>{
		int idx;
		int height;
		public node(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
		@Override
		public int compareTo(node o) {
			return this.height - o.height;
		}
	}
}