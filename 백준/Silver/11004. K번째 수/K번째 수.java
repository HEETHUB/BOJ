import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		quickSort(A);
		System.out.println(A[K-1]);
	}
	
	public static void quickSort(int[] A) {
		quickSortHelp(A, 0, A.length-1);
	}
	
	private static void quickSortHelp(int[] A, int start, int end) {
		if (start < end) {
			int pivot = partition(A, start, end);
			
			quickSortHelp(A, start, pivot-1);
			quickSortHelp(A, pivot+1, end);
		}
	}
	
	private static int partition(int[] A, int start, int end) {
		if (start + 1 == end) {
			if (A[start] > A[end]) swap(A, start, end);
			return end;
		}
		int mid = (start+end)/2;
		swap(A, mid, start);
		int pivot = A[start];
		int low = start+1;
		int high = end;
		while (low <= high) {
			while (pivot > A[low] && low < A.length-1) low++;
			while (pivot < A[high] && high > 0) high--;
			
			if (low <= high) swap(A, low++, high--);
		}
		A[start] = A[high];
		A[high] = pivot;
		return high;
	}
	
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}