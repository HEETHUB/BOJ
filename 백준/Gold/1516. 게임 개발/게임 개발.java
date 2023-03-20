import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		
		int[] arr = new int[N+1];
		int[] inDegree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			arr[i] = val;
			int temp = Integer.parseInt(st.nextToken());
			while (temp != -1) {
				list[temp].add(i);
				inDegree[i]++;
				temp = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> queue= new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		int[] ans = new int[N+1];
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int l : list[node]) {
				inDegree[l]--;
				ans[l] = Math.max(ans[l], ans[node] + arr[node]);
				if (inDegree[l] == 0) queue.add(l);
			}
		}
		
		for (int i = 1; i <= N; i++) 
			sb.append((ans[i]+arr[i])+"\n");
		
		System.out.println(sb);
	}
}