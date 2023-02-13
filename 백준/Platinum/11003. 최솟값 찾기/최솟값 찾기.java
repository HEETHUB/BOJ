import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
	
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new LinkedList<>();
	
		int start = -L+1;
		int end = 0;
		queue.addLast(arr[end]);
		bw.write(String.valueOf(queue.peek())+" ");
		
		while (end < N-1) {
			if (start < 0) {
				start++;
				end++;
				while (true) {
					if ( queue.isEmpty() || queue.peekLast() <= arr[end]) {
						queue.addLast(arr[end]);
						break;
					} else queue.removeLast();
				}
				bw.write(String.valueOf(queue.peekFirst())+" ");
			}
			else {
				end++;
				if (queue.peekFirst() == arr[start])
					queue.removeFirst();
					
				while (true) {
					if ( queue.isEmpty() || queue.peekLast() <= arr[end]) {
						queue.addLast(arr[end]);
						break;
						} else queue.removeLast();
				}
				bw.write(String.valueOf(queue.peekFirst())+" ");
				start++;
			}
		}
		bw.flush();
		bw.close();
	}
}