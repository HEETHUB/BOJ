import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			RGB[i][0] += Math.min(RGB[i-1][1], RGB[i-1][2]);
			RGB[i][1] += Math.min(RGB[i-1][0], RGB[i-1][2]);
			RGB[i][2] += Math.min(RGB[i-1][0], RGB[i-1][1]);
		}
		
		int ans = Math.min(RGB[N-1][0], Math.min(RGB[N-1][1], RGB[N-1][2]));
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
