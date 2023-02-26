import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(A*B/gcd(A,B)+"\n");
		}
		System.out.println(sb);
	}
	
	private static int gcd(int A, int B) {
		int X = Math.max(A, B);
		int Y = Math.min(A, B);
		
		int mod = X%Y;
		while (mod != 0) {
			X = Y;
			Y = mod;
			mod = X%Y;
		}
		return Y;
	}
}