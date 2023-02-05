import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cons = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cons[i][0] = Integer.parseInt(st.nextToken());
			cons[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		Arrays.sort(cons, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int ans = 0;
		int end = 0;
		for (int j = 0; j < N; j++) {
			if (cons[j][0] >= end) {
				ans++;					
				end = cons[j][1];
			}
		}

		System.out.println(ans);
	}
}