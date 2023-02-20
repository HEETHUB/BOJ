import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dice;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 출발 지점 6군데로 브루트포스 알고리즘
		
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < 6; i++) {
			max = Math.max(max, build(i));
		}
		System.out.println(max);
	}
	
	private static int build(int idx) {
//		System.out.println(idx + "----------");
		int sum = 0;
		int depth = 0;
		while (depth < N) {
			int next = botIdx(idx);
			if (dice[depth][idx] == 6 || dice[depth][next] == 6) {
				if (dice[depth][idx] == 5 || dice[depth][next] == 5)
					sum += 4;
				else sum += 5;
			} else sum += 6;
//			System.out.println(depth+" "+dice[depth][idx]+" "+dice[depth][next]+" "+sum);
			if (depth == N-1) break;
			idx = nextIdx(next, depth++);
		}
		return sum;
	}
	
	private static int nextIdx(int idx, int depth) {
		for (int i = 0; i < 6; i++) {
			if (dice[depth+1][i] == dice[depth][idx])
				return i;
		}
		return -1;
	}

	private static int botIdx(int i) {
		if (i == 0) return 5;
		if (i == 1) return 3;
		if (i == 2) return 4;
		if (i == 3) return 1;
		if (i == 4) return 2;
		else return 0;
	}
}