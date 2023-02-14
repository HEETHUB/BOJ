import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] A;
	
	public static void combi(int depth, String num, int idx) {
		if (depth == M) {
			System.out.println(num);
			return;
		}
		for (int i = idx; i < N; i++) {
			combi(depth+1, num+String.valueOf(A[i])+" ", i);
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
		
		combi(0, "", 0);
	}
}