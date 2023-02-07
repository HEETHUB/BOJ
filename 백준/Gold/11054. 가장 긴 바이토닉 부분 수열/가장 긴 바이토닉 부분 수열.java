import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+2];
		int[] dp = new int[N+2];
		int[] dp_rev = new int[N+2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (A[i] > A[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
				if (A[N+1-i] > A[N+1-j])
					dp_rev[N+1-i] = Math.max(dp_rev[N+1-i], dp_rev[N+1-j]+1);
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++)
			ans = Math.max(ans, dp[i]+dp_rev[i]-1);
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
