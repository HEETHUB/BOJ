import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		int ans = 0;
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == 0) return -1;
				if (o2 == 0) return 1;
				if (o1 * o2 > 0) return Math.abs(o1) - Math.abs(o2);
				else return o1 - o2;
			}
		});
		
		int idx = arr.length-1;
		while (idx >= 0) {
			if (idx == 0) ans += arr[idx--];
			else if (arr[idx] * arr[idx-1] > arr[idx] + arr[idx-1]) {
				ans += arr[idx] * arr[idx-1];
				idx -= 2;
			} else ans += arr[idx--];
		}
		
		System.out.println(ans);
	}
}