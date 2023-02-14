import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] ans;
	static Map<Integer, HashSet<Integer>> map = new HashMap<>();
	
	public static void makeTree(int root) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			for (int i : map.get(parent)) {
				queue.offer(i);
				ans[i] = parent;
				map.get(i).remove(parent);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ans = new int[N+1];
		
		for (int i = 1; i <= N; i++) 
			map.put(i, new HashSet<Integer>());
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken()); 
			map.get(A).add(B);
			map.get(B).add(A);
		}
		makeTree(1);
		for (int i = 2; i <= N; i++) {
			bw.write(ans[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
}