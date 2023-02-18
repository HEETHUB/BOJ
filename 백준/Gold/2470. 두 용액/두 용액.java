import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int max = 2000000000;
		int ansLeft = 0;
		int ansRight = 0;
		while(left < right) {
			int temp = arr[left] + arr[right];
			if (Math.abs(temp) < max) {
				max = Math.abs(temp);
				ansLeft = arr[left];
				ansRight = arr[right];
			}
			
			if (temp > 0) right--;
			else left++;
		}
		System.out.println(ansLeft+" "+ansRight);
	}
}