import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static int[][] map;
	static List<int[]> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NMD = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NMD.nextToken());
		M = Integer.parseInt(NMD.nextToken());
		D = Integer.parseInt(NMD.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[M];
		list = new ArrayList<>();
		combi(0, new int[3], -1);
		int ans = 0;
		for (int[] l : list) {
			ans = Math.max(ans, attack(l));
		}
		System.out.println(ans);
	}
	
	private static int attack(int[] l) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		int res = 0;
		int idx = N-1;
		int a1 = l[0];
		int a2 = l[1];
		int a3 = l[2];
		while (idx >= 0) {
			int[] target1 = aim(a1, idx, temp);
			int[] target2 = aim(a2, idx, temp);
			int[] target3 = aim(a3, idx, temp);
			if (target1 != null && temp[target1[0]][target1[1]] == 1) {
				temp[target1[0]][target1[1]] = 0;
				res++;
			}
			if (target2 != null && temp[target2[0]][target2[1]] == 1) {
				temp[target2[0]][target2[1]] = 0;
				res++;
			}
			if (target3 != null && temp[target3[0]][target3[1]] == 1) {
				temp[target3[0]][target3[1]] = 0;
				res++;
			}
			idx--;
		}
		return res;
	}

	private static int[] aim(int a1, int idx, int[][] temp) {
		int r = idx;
		int c = a1;
		for (int i = 0; i < D; i++) {
			for (int k = 0; k <= 2*i; k++) {
				int nr = r - (i - Math.abs(i-k));
				int nc = c - (i - k);
				if (check(nr, nc) && temp[nr][nc] == 1)
					return new int[] {nr, nc};
			}
		}
		return null;
	}

	private static boolean check(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < M) return true;
		return false;
	}

	private static void combi(int idx, int[] arr, int i) {
		if (idx == 3) {
			list.add(Arrays.copyOf(arr, arr.length));
			return;
		}
		for (int j = i+1; j < M; j++) {
			if (!visited[j]) {
				visited[j] = true;
				arr[idx] = j;
				combi(idx+1, arr, j);
				visited[j] = false;
			}
		}
	}
}