import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static boolean finish;
	static ArrayList<int[]> zero;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		zero = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0)
					zero.add(new int[] {i, j});
			}
		}
		int start = 0;
		make(start, check(zero.get(start)));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void make(int idx, int[] set) {
		int[] node = zero.get(idx);
		if (idx == zero.size()-1) {
			for (int i = 1; i <= 9; i++) {
				if (set[i] > 0)
					sudoku[node[0]][node[1]] = set[i];
			}
			finish = true;
			return;
		}
		
		if (set != null) {
			for (int i = 1; i <= 9; i++) {
				if (set[i] > 0) {
					sudoku[node[0]][node[1]] = set[i];
					make(idx+1, check(zero.get(idx+1)));
					if (finish) return;
					sudoku[node[0]][node[1]] = 0;
				}
			}
		}
	}
	
	private static int[] check(int[] node){
		int[] set = {0,1,2,3,4,5,6,7,8,9};
		
		for (int i = 0; i < 9; i++) {
			set[sudoku[node[0]][i]] = 0;
			set[sudoku[i][node[1]]] = 0;
		}
		int nr = node[0] - node[0]%3;
		int nc = node[1] - node[1]%3;
		for (int i = nr; i < nr + 3; i++){
			for (int j = nc; j < nc + 3; j++) {
				set[sudoku[i][j]] = 0;
			}
		}
		for (int i = 0; i <= 9 && set[i] == 0; i++) {
			if (i == 9) return null;
		}
		return set;
	}
}