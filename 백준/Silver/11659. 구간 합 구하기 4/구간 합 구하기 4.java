import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N+1];
		int first, last;
		
		for (int i = 1; i <= N; i++)
			nums[i] = nums[i-1] + sc.nextInt();
		
		for (int m = 0; m < M; m++) {
			first = sc.nextInt();
			last = sc.nextInt();
			System.out.println(nums[last]-nums[first-1]);
		}
	}
}