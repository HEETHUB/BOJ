import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = prime(N);
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			if (pelindrome(temp)) {
				System.out.println(temp);
				break;
			}
		}
	}
	
	private static Queue<Integer> prime(int N) {
		int[] nums = new int[10000001];
		for (int i = 2; i < 10000001; i++) 
			nums[i] = i;
		
		for (int i = 2; i * i < 10000000; i++) {
			if (nums[i] != 0) {
				for (int j = i+i; j < 10000000; j += i)
					nums[j] = 0;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = N; i <= 10000000; i++) {
			if (nums[i] != 0) queue.add(i);
		}
		return queue;
	}

	private static boolean pelindrome(long N) {
		String str = Long.toString(N);
		int mid = str.length()/2;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		}
		return true;
	}
}