import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] divided;
	static Map<Integer, HashSet<Integer>> map;
	static String ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for (int k = 1; k <= K; k++) {
			StringTokenizer VE = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(VE.nextToken());
			int E = Integer.parseInt(VE.nextToken());
			HashSet<Integer>[] set = new HashSet[2];
			set[0] = new HashSet<>();
			set[1] = new HashSet<>();
			
			ans = "YES";
			
			map = new HashMap<>();
			for (int i = 1; i <= V; i++)
				map.put(i, new HashSet<>());
			
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				map.get(A).add(B);
				map.get(B).add(A);
			}
			
			divided = new int[V+1];
			
			for (int i = 1; i <= V; i++) {
				if (divided[i] == 0)
					bfs(i);
			}
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		divided[num] = -1;
		queue.add(num);
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
//			System.out.println(node + " " + Arrays.toString(divided)+ " "+ ans);
			for (int i : map.get(node)) {
				if (divided[i] == 0) {
					switch (divided[node]) {
					case 1:
						divided[i] = -1;
						break;
					case -1:
						divided[i] = 1;
						break;
					}
					queue.add(i);
				} else {
					if (divided[i] == divided[node]) {
						ans = "NO";
						break;
					}
				}
			}
		}
	}
}