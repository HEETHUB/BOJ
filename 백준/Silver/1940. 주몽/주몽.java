import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int sum = arr[i]+arr[j];
				if (sum == M) {
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}