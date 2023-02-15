import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static class myArrays implements Comparable<myArrays>{
		int val;
		int idx;
		
		public myArrays(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(myArrays o) {
			return this.val - o.val;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		myArrays[] arr = new myArrays[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new myArrays(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(arr);
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i].idx - i);
		}
		System.out.println(max+1);
	}
}