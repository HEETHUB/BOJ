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
		long pick1 = 0;
		long pick2 = 0;
		long pick3 = 0;
       
		for (int mid = 1; mid < N-1; mid++) {
			int left = 0;
			int right = N-1;
			while (left < mid && right > mid) {
				long temp = arr[left] + arr[mid] + arr[right];
				if (Math.abs(temp) < min) {
					min = Math.abs(temp);
					pick1 = arr[left];
					pick2 = arr[mid];
					pick3 = arr[right];
				}
				if (temp > 0) right--;
				else left++;
			}
		} // N^2
		System.out.println(pick1+" "+pick2+" "+pick3);
		
	}
}