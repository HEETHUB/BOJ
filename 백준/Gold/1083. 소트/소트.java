import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int S = Integer.parseInt(br.readLine());

		outer: for (int i = 0; i < N - 1; i++) {
			int max = i;
			for (int j = i; j <= i + S; j++) {
				if (arr[max] < arr[j])
					max = j;
				if (j == N - 1)
					break;
			}
			for (int k = i + 1; k <= max; k++) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
			S -= max - i;
			if (S == 0)
				break outer;
		}

		for (int n : arr) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}