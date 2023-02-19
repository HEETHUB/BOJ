import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i][1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		boolean[] visited = new boolean[max+1];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (visited[arr[i][1]] == false) {
				visited[arr[i][1]] = true;
				ans += arr[i][0];
			} else {
				for (int d = arr[i][1]-1; d >= 1; d--) {
					if (visited[d] == false) {
						ans += arr[i][0];
						visited[d] = true;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}