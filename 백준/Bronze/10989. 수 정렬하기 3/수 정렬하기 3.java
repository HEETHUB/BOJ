import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
	
		int K = 1;
		int div = 10;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i]/div>=1) {
				div *= 10;
				K++;
			}
		}
        
		radixSort(arr, K);
		for (Integer a : arr)
			sb.append(a).append("\n");
		System.out.println(sb);
	}
	
	public static void radixSort(int[] arr, int max_size) {
		int[] output = new int[arr.length];
		int k = 1;
		
		for (int cnt = 0; cnt < max_size; cnt++) { // 최대 자릿수만큼 반복 
			int[] bucket = new int[10];
			
			for (int i = 0; i < arr.length; i++) 
				bucket[(arr[i]/k)%10]++; // 일의 자리부터 시작해서 채워넣
			
			for (int i = 1; i < 10; i++)
				bucket[i] += bucket[i-1]; // 각 자리가 몇 번째 index부터 시작할 지 구하기
			
			for (int i = arr.length-1; i >= 0; i--) {
				output[bucket[(arr[i]/k)%10]-1] = arr[i];
				bucket[(arr[i]/k)%10]--;
			}
			
			for (int i = 0; i < arr.length; i++) 
				arr[i] = output[i];
			
			k *= 10;
		}
	}
}