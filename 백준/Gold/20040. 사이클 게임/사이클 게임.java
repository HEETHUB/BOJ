import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i;
		
		int ans = 0;
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (ans > 0) continue;
			if (find(s) == find(e)) ans = i;
			else union(s, e);
		}
		System.out.println(ans);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) arr[b] = a;
	}

	private static int find(int a) {
		if (a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
}