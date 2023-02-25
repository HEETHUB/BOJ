import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()) - arr[0];
		}
		arr[0] = 0;
		
		Arrays.sort(arr);

		int gcd = 0;
		for (int i = arr[1] - arr[0]; i >= 2; i--) {
			boolean check = true;
			long mod = arr[0]%i;
			for (int j = 1; j < N; j++) {
				if (arr[j]%i != mod) {
					check = false;
					break;
				}
			}
			if (check) {
				gcd = i;
				break;
			}
		}
		
		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0) {
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
	}
}