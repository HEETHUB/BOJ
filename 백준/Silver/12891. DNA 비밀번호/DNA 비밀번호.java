import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String DNA = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		int ans = 0;
		
		for (int i = 0; i < 4; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = P-1;
		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;
		for (int i = start; i <= end; i++) {
			if (DNA.charAt(i) == 'A') A++;
			if (DNA.charAt(i) == 'C') C++;
			if (DNA.charAt(i) == 'G') G++;
			if (DNA.charAt(i) == 'T') T++;
		}
		
		while (end < S) {
			if (A >= arr[0] && C >= arr[1] && G >= arr[2] && T >= arr[3])
				ans++;
			if (DNA.charAt(start) == 'A' ) A--;
			else if (DNA.charAt(start) == 'C' ) C--;
			else if (DNA.charAt(start) == 'G' ) G--;
			else if (DNA.charAt(start) == 'T' ) T--;
			start++;
			end++;
			if (end == S) break;
			
			if (DNA.charAt(end) == 'A') A++;
			else if (DNA.charAt(end) == 'C') C++;
			else if (DNA.charAt(end) == 'G') G++;
			else if (DNA.charAt(end) == 'T') T++;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}