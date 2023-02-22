import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		int left = 1;
		int right = k;
		int ans = 0;
		while (left <= right) {
			int mid = (left+right)/2;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += Math.min(N, mid/i);
			}

			if (sum < k) left = mid + 1;
			else if (sum >= k) {
				right = mid - 1;
				ans = mid;
			}
		}
		System.out.println(ans);
	}
}