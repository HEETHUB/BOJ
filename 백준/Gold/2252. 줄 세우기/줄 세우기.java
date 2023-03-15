import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int[] tp = new int[N+1];
		boolean[] visited= new boolean[N+1];
		for (int i = 0; i < N+1; i++) 
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			list[front].add(back);
			tp[back]++;
		}
		
//		for (ArrayList<Integer> l : list) System.out.println(l);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (tp[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp+" ");
			for (int child : list[temp]) {
				tp[child]--;
				if (tp[child] == 0 && !visited[child]) {
					queue.add(child);
					visited[child] = true;
				}
			}
		}
		System.out.println(sb);
	}
}