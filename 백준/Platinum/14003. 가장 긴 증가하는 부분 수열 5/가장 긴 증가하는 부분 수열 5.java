import java.io.*;
import java.util.*;

public class Main {
	static long[] arr, res, dp;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new long[N];
		res = new long[N];
		dp = new long[N];
		int size = 0;
		int maxIdx = 0; 
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				res[size] = arr[i];
				dp[i] = size+1;
				size++;
			}
			else {
				if (arr[i] > res[size-1]) {
					res[size] = arr[i];
					dp[i] = size+1;
					size++;
					maxIdx = i;
				}
				else {
					int idx = search(0, size-1, i);
					res[idx] = arr[i];
					dp[i] = idx+1;
				}
			}
		}
		sb.append(size+"\n");
		Stack<Long> stack = new Stack<>();
		for (int i = N-1; i >= 0 && size >= 0; i--) {
			if (dp[i] == size) {
				stack.push(arr[i]);
				size--;
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop()+" ");
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(sb);
	}
	
	private static int search(int start, int end, int idx) {
		int left = start;
		int right = end;
		while (left < right) {
			int mid = (left+right)/2;
			if (res[mid] >= arr[idx]) right = mid;
			else if (res[mid] < arr[idx]) left = mid+1; 
		}
		return right;
	}
}