import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		boolean[] check = new boolean[(int)(max - min + 1)];
		
		for (long i = 2; i*i <= max; i++) {
			long sq = i*i;
			long start = min/sq;
			
			if (min % sq != 0) start++;
			
			for (long j = start; sq * j <= max; j++) 
				check[(int)((j*sq) - min)] = true;
		}
		
		int ans = 0;
		for (int i = 0; i <= max - min; i++) {
			if (!check[i]) ans++;
		}
		
		System.out.println(ans);
	}
}