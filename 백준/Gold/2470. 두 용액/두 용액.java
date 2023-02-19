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
		int min = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		while(left < right) {
			int temp = arr[left] + arr[right];
			if (Math.abs(temp) < min) {
				min = Math.abs(temp);
				ans1 = arr[left];
				ans2 = arr[right];
			}
			
			if (temp > 0) right--;
			else left++;
		}
		System.out.println(ans1+" "+ans2);
	}
}