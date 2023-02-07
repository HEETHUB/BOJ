import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int ans = 0;
	
	public static void dfs(int r, int N, boolean[] col, boolean[] diag1, boolean[] diag2) {
		if (r == N) {
			ans++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if (col[c] && diag1[r+c] && diag2[r-c+(N-1)]) {
				col[c] = diag1[r+c] = diag2[r-c+(N-1)] = false;
				dfs(r+1, N, col, diag1, diag2);
				col[c] = diag1[r+c] = diag2[r-c+(N-1)] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] col = new boolean[N];
		boolean[] diag1 = new boolean[2 * N - 1];
		boolean[] diag2 = new boolean[2 * N - 1];
		Arrays.fill(col, true);
		Arrays.fill(diag1, true);
		Arrays.fill(diag2, true);
		
		dfs(0, N, col, diag1, diag2);
		
		System.out.println(ans);
	}
}
