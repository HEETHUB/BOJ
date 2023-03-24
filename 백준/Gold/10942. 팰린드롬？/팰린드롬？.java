import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (isPalindrome(s, e)) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
	}

	private static boolean isPalindrome(int s, int e) {
		for (int i = 0; i <= (e-s)/2; i++) {
			if (arr[s+i] != arr[e-i]) return false;
		}
		return true;
	}
}