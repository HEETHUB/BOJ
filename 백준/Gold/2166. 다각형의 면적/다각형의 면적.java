import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] x = new long[N+1];
		long[] y = new long[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		x[N] = x[0];
		y[N] = y[0];
		long sum_p = 0;
		long sum_m = 0;
		for (int i = 0; i < N; i++) {
			sum_p += x[i] * y[i+1];
			sum_m += x[i+1] * y[i];
		}
		
		String ans = String.format("%.1f", (Math.abs(sum_p-sum_m)/2.0));
		System.out.println(ans);
	}
}