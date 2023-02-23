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
		
		for (int i = 0; i < R; i++) {
			if (pipeLine(i, 0))
				ans++;
		}
			
		System.out.println(ans);
	}

	private static boolean pipeLine(int r, int c) {
		visited[r][c] = true;
		
		if (c == C-1) 
			return true;
		
		if (boundary(r-1, c+1) && !visited[r-1][c+1] && pipeLine(r-1, c+1)) 
			return true;
		if (boundary(r, c+1) && !visited[r][c+1] && pipeLine(r, c+1)) 
			return true;
		if (boundary(r+1, c+1) && !visited[r+1][c+1] && pipeLine(r+1, c+1)) 
			return true;
		return false;
	}
	
	private static boolean boundary(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) return true;
		return false;
	}
}