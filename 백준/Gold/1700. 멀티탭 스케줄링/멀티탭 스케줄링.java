import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer>[] products = new LinkedList[K+1];
		for (int i = 0; i <= K; i++)
			products[i] = new LinkedList<>();
		
		products[0].add(-1);
		
		int[] arr = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			products[arr[i]].add(i);
		}
		
//		for (int i = 1; i <= K; i++) {
//			while (!products[i].isEmpty())
//				System.out.println(i+" "+products[i].poll());
//		}
		
		
		boolean[] used = new boolean[K+1];
		
		int ans = 0;
        int k = 0;
		for (int i = 0; i < K; i++) {
			if (k < N) {
                if (!used[arr[i]]) {
                    k++;
                    used[arr[i]] = true;
                }
				products[arr[i]].poll();
			}
			else if (used[arr[i]]) {
				products[arr[i]].poll();
				continue;
			}
			else {
				int min = 0;
				for (int j = 1; j <= K; j++) {
					if (used[j] && products[j].isEmpty()) {
						min = j;
						break;
					} else if (used[j] && !products[j].isEmpty()) {
						if (products[j].peek() > products[min].peek()) min = j;
					}
				}
				used[min] = false;
				used[arr[i]] = true;
				products[arr[i]].poll();
				ans++;
//				System.out.println(i + " "+arr[i]+" pop "+min+" "+ans);
			}
		}
		System.out.println(ans);
	}
}