import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N+2];
		int[] dp = new int[N+2];
		for (int i = 0; i < N; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		int ans = 0;
		while (idx < N) {
			if (A[idx] == 0) {
				idx++;
				continue;
			}
			int temp = A[idx];
			ans += 3*temp;
			A[idx] = 0;
//			if (A[idx+1] >= A[idx+2]) {
//				int temp2 = Math.min(temp, A[idx+1] - A[idx+2]);
//				ans += 2*temp2;
//				A[idx+1] -= temp2;
//				temp -= temp2;
//			}
			temp = Math.min(temp, A[idx+1]);
			ans += 2*temp;
			A[idx+1] -= temp;
//			temp = Math.min(ans, temp)
			int temp2 = Math.min(A[idx+1], A[idx+2]);
			int temp3 = Math.min(temp, A[idx+2]-temp2);
			ans += 2*temp3;
			A[idx+2] -= temp3;
			idx++;
		}
		
		System.out.println(ans);
	}
}