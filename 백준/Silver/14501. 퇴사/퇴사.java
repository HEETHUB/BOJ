import java.util.Scanner;

public class Main {
	static int N;
	static int[][] L;
	
	public static int consult(int i) {
		if (i >= N)
			return 0;
		else {
			int earn;
			if (i + L[i][0] <= N) {
				earn = L[i][1];
				int next = 0;
				for (int j = i+L[i][0]; j < N; j++) {
					next = Math.max(next, consult(j));
				}
				earn += next;
				return earn;
			} else {
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			L[i][0] = sc.nextInt();
			L[i][1] = sc.nextInt();
		}
		sc.close();
		int ans = 0;
		
		for (int i = 0; i < N; i++) 
			ans = Math.max(ans, consult(i));
		
		System.out.println(ans);
	}
}
