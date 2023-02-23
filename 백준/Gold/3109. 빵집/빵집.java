import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int R, C, ans;
	static String[] ground;
	static boolean[][] visited;
	static boolean fin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String RC = br.readLine();
		R = Integer.parseInt(RC.split(" ")[0]);
		C = Integer.parseInt(RC.split(" ")[1]);
		
		ground = new String[R];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			ground[i] = br.readLine();
			for (int j = 0; j < C; j++) {
				if (ground[i].charAt(j) == 'x')
					visited[i][j] = true;
			}
		}
//		for (boolean[] v : visited) System.out.println(Arrays.toString(v));
		
		for (int i = 0; i < R; i++) {
			fin = false;
			visited[i][0] = true;
			pipeLine(i, 0);
		}
			
//		for (boolean[] v : visited) System.out.println(Arrays.toString(v));
		System.out.println(ans);
	}

	private static void pipeLine(int r, int c) {
		if (c == C-1) {
			ans++;
			fin = true;
//			for (boolean[] v : visited) System.out.println(Arrays.toString(v));
			return;
		}
		
		int[] dr = {-1, 0, 1};
		int[] dc = {1, 1, 1};
		
		for (int k = 0; k < 3; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					pipeLine(nr, nc);
					if (fin) break;
//					visited[nr][nc] = false;
				}
			}
		}
	}
}