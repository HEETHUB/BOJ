import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM = br.readLine();
		int N = Integer.parseInt(NM.split(" ")[0]);
		int M = Integer.parseInt(NM.split(" ")[1]);
		
		int[] lessons = new int[N];
		int max = 0;
		int left = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
			if (left < lessons[i]) left = lessons[i];
			max += lessons[i];
		}
		
		int right = max;

		while (left <= right) {
			int cnt = 0;
			int mid = (left+right)/2;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sum + lessons[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += lessons[i];
			}
			
			if (sum != 0) cnt++;
			
			if (cnt > M) {
				left = mid +1;
			} else right = mid - 1;
		}
		System.out.println(left);
	}
}