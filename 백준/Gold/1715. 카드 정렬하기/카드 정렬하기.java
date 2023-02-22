import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		int ans = 0;
		for (int i = 0; i < N; i++) 
			queue.add(Integer.parseInt(br.readLine()));
		
		while (queue.size() > 1) {
			int pick1 = queue.poll();
			int pick2 = queue.poll();
			ans += pick1 + pick2;
			queue.add(pick1 + pick2);
		}
		
		System.out.println(ans);
	}
}