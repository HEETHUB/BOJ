import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NS = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NS.nextToken());
		int S = Integer.parseInt(NS.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = N+1;
		int left = 0;
		int right = 0;
		int sum = arr[0];
		while (right < N && left <= right) {
			if (sum < S) {
				right++;
				if (right < N)
					sum += arr[right];
			} else {
//				System.out.println(left+" "+right);
				ans = Math.min(ans, right-left+1);
				sum -= arr[left];
				left++;
			}
		}
		
		if (ans == N+1) ans = 0;
		System.out.println(ans);
	}
}