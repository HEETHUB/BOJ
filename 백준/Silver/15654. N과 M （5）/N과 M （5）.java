import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] A;
	
	public static void combi(int depth, String num, boolean[] visited) {
		if (depth == M) {
			System.out.println(num);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combi(depth+1, num+String.valueOf(A[i])+" ", visited);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		Arrays.sort(A);
		
		combi(0, "", new boolean[N]);
	}
}