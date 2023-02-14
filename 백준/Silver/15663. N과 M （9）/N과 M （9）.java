import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static int[] A;
	static Set<String> set = new LinkedHashSet<>();
	
	public static void combi(int depth, String num, boolean[] visited) {
		if (depth == M) {
			set.add(num);
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
		for (String s : set)
			System.out.println(s);
	}
}