import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken()); // N

		Arrays.sort(arr); // NlogN

		long min = Long.MAX_VALUE;
		long ans1 = 0;
		long ans2 = 0;
		long ans3 = 0;
		
		for (int mid = 1; mid < N-1; mid++) {
			int left = 0;
			int right = N-1;
			while (left < mid && right > mid) {
				long temp = arr[left] + arr[mid] + arr[right];
				if (Math.abs(temp) < min) {
					min = Math.abs(temp);
					ans1 = arr[left];
					ans2 = arr[mid];
					ans3 = arr[right];
				}
				if (temp > 0) right--;
				else left++;
			}
		}
		System.out.println(ans1+" "+ans2+" "+ans3);
	}
}