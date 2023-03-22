import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		int left = 0;
		int right = N-1;
		long sum = Long.MAX_VALUE;
		long pick1 = 0;
		long pick2 = 0;
		while (left < right) {
			long temp = arr[left] + arr[right];
			if (Math.abs(temp) <= sum) {
				sum = Math.abs(temp);
				pick1 = arr[left];
				pick2 = arr[right];
			}
			if (temp < 0) left++;
			else if (temp > 0) right--;
			else break;
		}
		System.out.println(pick1 + " " + pick2);
	}
}