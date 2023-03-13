import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		long[] padovan = new long[101];
		padovan[1] = 1;
		padovan[2] = 1;
		padovan[3] = 1;
		for (int i = 4; i <= 100; i++) {
			padovan[i] = padovan[i-2] + padovan[i-3];
		}
		
		for (int t = 1; t <= T; t++) {
			sb.append(padovan[sc.nextInt()]+"\n");
		}
		System.out.println(sb);
	}
}