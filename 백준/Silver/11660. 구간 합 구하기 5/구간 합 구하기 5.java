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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] nums = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] D = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + nums[i][j];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			int ans = D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1];
			bw.write(String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}