import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] res = new int[N];
		res[0] = arr[0];
		int size = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] > res[size-1]) res[size++] = arr[i];
			else {
				int left = 0;
				int right = size-1;
				while (left < right) {
					int mid = (left+right)/2;
					if (res[mid] >= arr[i]) right = mid;
					else if (res[mid] < arr[i]) left = mid+1; 
				}
				res[right] = arr[i];
			}
		}
		System.out.println(size);
	}
}