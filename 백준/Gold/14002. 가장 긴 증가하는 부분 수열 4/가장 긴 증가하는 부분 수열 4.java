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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];
		int[] dp = new int[N+1];
		int ans = 0;
		int ansIdx = 0;
 		
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (A[i] > A[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			if (ans < dp[i]) {
				ans = dp[i];
				ansIdx = i;
			}
		}
		
		int[] result = new int[ans+1];
		result[ans] = A[ansIdx];
		int idx = ansIdx-1;
		for (int i = ans-1; i >= 1; i--) {
			while (true) {
				if (dp[idx] == i && A[idx] < result[i+1]) {
					result[i] = A[idx--];
					break;
				}
				idx--;
			}
		}
		bw.write(String.valueOf(ans));
		bw.newLine();
		for (int i = 1; i <= ans; i++)
			bw.write(String.valueOf(result[i])+" ");
		bw.flush();
		bw.close();
	}
}
