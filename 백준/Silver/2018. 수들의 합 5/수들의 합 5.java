import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 1;
		int end = 1;
		int num = 1;
		int ans = 1;
		while (end != N) {
			if (num == N) {
				ans++;
				num += ++end;
			}
			else if (num < N) 
				num += ++end;
			else {
				num -= start++;
			}
		}
		System.out.println(ans);
			
	}
}