import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		public int value;
		public int idx;
		
		Node(int value, int idx){
			this.value = value;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			// 새로운 값이 들어올 때마다 정렬하는 대신 현재 수보다 큰 값을 덱에서 제거하여 시간복잡도 줄이
			
			while (!deque.isEmpty() && deque.getLast().value > cur)
				deque.removeLast();
			
			deque.addLast(new Node(cur, i));
			// 범위에서 벗어난 값은 덱에서 제거
			if (deque.getFirst().idx <= i - L) 
				deque.removeFirst();
			
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
}