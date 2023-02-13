import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		for (int n = 0; n < N; n++) {
			int start = 0;
			int end = N-1;
			while (start < end) {
				if (n == start) {
					start++;
					continue;
				}
				if (n == end) {
					end--;
					continue;
				}
				if (nums[start]+nums[end] == nums[n]) {
					ans++;
					break;
				}
				else if (nums[start]+nums[end] < nums[n])
					start++;
				else if (nums[start]+nums[end] > nums[n])
					end--;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}