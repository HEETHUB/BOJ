import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		node[] arr = new node[N];
		for (int i = 0; i < N; i++)
			arr[i] = new node();
		
		PriorityQueue<node> pq1 = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.B - o2.B;
			}
		});
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i].A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i].B = Integer.parseInt(st.nextToken());
			pq1.add(arr[i]);
		}

//		Arrays.sort(arr, new Comparator<node>() {
//			@Override
//			public int compare(node o1, node o2) {
//				return o1.B - o2.B;
//			}
//		});

		long ans = pq1.poll().A;

		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 1; i < N - 1; i += 2) {
			pq2.add(pq1.poll().A);
			pq2.add(pq1.poll().A);
			ans += pq2.poll();
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static class node {
		int A;
		int B;
	}
}