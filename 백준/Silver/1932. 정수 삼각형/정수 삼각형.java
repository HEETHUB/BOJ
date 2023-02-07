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
		int[][] tree = new int[N][N];
		int[][] cache = new int[N][N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
				if (i > 0) {
					if (j == 0)
						tree[i][j] += tree[i-1][0];
					else 
						tree[i][j] += Math.max(tree[i-1][j-1], tree[i-1][j]);
				}
                ans = Math.max(ans, tree[i][j]);
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
