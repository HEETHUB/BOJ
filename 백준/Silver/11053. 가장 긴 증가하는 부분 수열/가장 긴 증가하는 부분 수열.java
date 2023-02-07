import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];
		int[] dp = new int[N+1];
		
		A[0] = 0;
		for (int i = 1; i < N+1; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int temp = 0;
		int ans = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (A[i] > A[j]) 
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
