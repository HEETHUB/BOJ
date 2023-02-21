import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] weights = new int[N];
		for (int i = 0; i < N; i++) 
			weights[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(weights);
		
		int min = 1;
		for (int weight : weights) {
			if (weight > min) break;
			if (weight <= min) min += weight;
		}
		System.out.println(min);
	}
}