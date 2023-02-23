import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NK = br.readLine();
		int N = Integer.parseInt(NK.split(" ")[0]);
		int K = Integer.parseInt(NK.split(" ")[1]);

		int[][] jewels = new int[N][2];
		for (int i = 0; i < N; i++) {
			String MV = br.readLine();
			jewels[i][0] = Integer.parseInt(MV.split(" ")[0]);
			jewels[i][1] = Integer.parseInt(MV.split(" ")[1]);
		}

		long[] C = new long[K];
		for (int i = 0; i < K; i++)
			C[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(jewels, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(C);
//		for (int[] j : jewels) System.out.println(Arrays.toString(j));
//		System.out.println(Arrays.toString(C));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		long ans = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && jewels[idx][0] <= C[i])
				pq.add(jewels[idx++][1]);
			if (!pq.isEmpty())
				ans += pq.poll();
		}
		System.out.println(ans);
	}
}