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
		int M = Integer.parseInt(st.nextToken());
		
		long[] S = new long[N];
		long[] C = new long[M];
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++)
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			if (remainder == 0) ans++;
			C[remainder]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1)
			ans += (C[i]*(C[i]-1)/2);
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}