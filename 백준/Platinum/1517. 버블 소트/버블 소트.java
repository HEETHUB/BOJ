import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		mergeSort(arr);
		System.out.println(cnt);
	}
	
	static long[] sorted;
	
	public static void mergeSort(long[] arr) {
		sorted = new long[arr.length];
		mergeSortHelp_BU(arr, 0, arr.length-1);
		sorted = null;
	}
	
	private static void merge(long[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left;
		
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				sorted[idx++] = arr[l++];
			}
			else {
				cnt += r - idx;
				sorted[idx++] = arr[r++];
			}
				
		}
		
		while (l <= mid) {
			sorted[idx++] = arr[l++];
		}
		
		while (r <= right) {
			sorted[idx++] = arr[r++];
		}
		
		for (int i = left; i <= right; i++)
			arr[i] = sorted[i];
	}
	
	private static void mergeSortHelp_BU(long[] arr, int left, int right) {
		if (left == right) return;
		
		for (int size = 1; size <= right; size += size) {
			for (int l = left; l <= right-size; l += 2*size) {
				int start = l;
				int mid = l + size - 1;
				int end = Math.min(l + 2*size - 1, right);
				merge(arr, start, mid, end);
			}
		}
	}
}