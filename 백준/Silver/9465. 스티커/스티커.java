import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N+1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[] dpUp = new int[N+1];
			int[] dpDown = new int[N+1];
			int[] dpNon = new int[N+1];
			for (int i = 1; i <= N; i++) {
				dpNon[i] = Math.max(dpUp[i-1], dpDown[i-1]);
				dpUp[i] = Math.max(dpNon[i-1]+arr[0][i], dpDown[i-1]+arr[0][i]);
				dpDown[i] = Math.max(dpNon[i-1]+arr[1][i], dpUp[i-1]+arr[1][i]);
			}
			int ans = Math.max(dpUp[N], dpDown[N]);
			bw.write(String.valueOf(ans)+"\n");
		}
		bw.flush();
		bw.close();
	}
}