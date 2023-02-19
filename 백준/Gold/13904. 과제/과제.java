import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[N][2];

		int max = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i][0]);
		}

		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o2[1] - o1[1];
			}
		});

		int[] day = new int[max + 1];
		int ans = 0;
		
		for (Integer[] work : arr) {
			for (int j = work[0]; j >= 1; j--) {
				if (day[j] == 0) {
					day[j] = work[1];
					ans += work[1];
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}