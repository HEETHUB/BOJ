import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long A, B, a, b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		int b = (int)Math.pow(B, 0.5);
//		System.out.println(A+" "+a+" "+B+" "+b);
		
		int ans = 0;
		Queue<Integer> queue = prime(b);
//		System.out.println(queue);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 2; i <= 47; i++) {
				long num = (long)Math.pow(temp, i);
				if (num > B) break;
				else if (num >= A && num <= B) ans++;
			}
		}
		System.out.println(ans);
	}
	
	private static Queue<Integer> prime(int b) {
		int[] arr = new int[b+1];
		
		for (int i = 2; i <= b; i++) 
			arr[i] = i;
		
		for (int i = 2; i*i <= b; i++) {
			if (arr[i] != 0) {
				for (int j = i+i; j <= b; j += i) {
					arr[j] = 0;		
				}
			}
		}
		
		Queue<Integer> list = new LinkedList<>();
		for (int i = 2; i <= b; i++) {
			if (arr[i] != 0) list.add(arr[i]);
		}
		
		return list;
	}
}

// 소수들을 구한다. 
// 2부터 b까지 수들 중 소수만 뽑아서 대입해봄.