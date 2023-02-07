import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] tree = new int[N][N];
		int[][] cache = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				tree[i][j] = sc.nextInt();
				if (i > 0) {
					if (j == 0)
						tree[i][j] += tree[i-1][0];
					else 
						tree[i][j] += Math.max(tree[i-1][j-1], tree[i-1][j]);
				}
			}
		}
		int ans = 0;
		for (int k = 0; k < N; k++) 
			ans = Math.max(ans, tree[N-1][k]);
		System.out.println(ans);
	}
}
