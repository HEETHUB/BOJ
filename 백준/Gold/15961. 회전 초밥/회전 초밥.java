import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int[] sushis = new int[3001];
		HashSet<Integer> set = new HashSet<>();
		int left = 0;
		int right = k-1;
		for (int i = left; i <= right; i++) {
			set.add(arr[i]);
			sushis[arr[i]]++;
		}
		
//		System.out.println(Arrays.toString(arr));
		
		int max = set.size();
//		System.out.println(left+" "+max+" "+set.toString());
		if (!set.contains(c)) max++;
		while (left < N) {
			// left++
			if (sushis[arr[left]] == 1) 
				set.remove(arr[left]);
			sushis[arr[left]]--;
			left++;
			
			// right++
			right = (right+1)%N;
			sushis[arr[right]]++;
			set.add(arr[right]);
			
			// max update
			int temp = set.size();
			if (!set.contains(c)) temp++;
			max = Math.max(max, temp);
//			System.out.println(left+" "+right+" "+max+" "+set.toString());
		}
		System.out.println(max);
	}
}