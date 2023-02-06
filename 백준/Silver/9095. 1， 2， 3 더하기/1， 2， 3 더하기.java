import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int ans;
	static void makeN(int num) {
		if (num == n) {
			ans++;
			return;
		}
		if (num+3 <= n) makeN(num+3);
		if (num+2 <= n) makeN(num+2);
		if (num+1 <= n) makeN(num+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			
			makeN(0);
			bw.write(String.valueOf(ans));
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
	}
}
