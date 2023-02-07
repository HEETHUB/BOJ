import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main  {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N];
		int ans = 0;
		int idx = 0;
		cnt[0]++;
        
		while (true) {
			if (cnt[idx] == M) break;
			if (cnt[idx]%2 == 1) 
                idx = (idx+L)%N;
			else 
                idx = (idx+N-L)%N;
            cnt[idx]++;
        	ans++;
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		
	}
}