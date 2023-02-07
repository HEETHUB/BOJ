import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		int weight, value;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st2.nextToken());
			values[i] = Integer.parseInt(st2.nextToken());
		}
		br.close();
		
		int[][] dp = new int[N+1][K+1];;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (weights[i] > j) 
					dp[i][j] = dp[i-1][j];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]); 
			}
		}
		
		bw.write(String.valueOf(dp[N][K]));
		bw.flush();
		bw.close();
		
		
	}
}
