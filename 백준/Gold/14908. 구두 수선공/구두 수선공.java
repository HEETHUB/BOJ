import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[1]*o1[0] == o1[1]*o2[0]) return o1[2] - o2[2];
				return o2[1]*o1[0] - o1[1]*o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1});
		}
		for (int i = 0; i < N; i++)
			sb.append(pq.poll()[2] + " ");
		System.out.println(sb);
	}
}