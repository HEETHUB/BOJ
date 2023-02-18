import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[100][100];
	static int r, c, k;
	static int mr = 3;
	static int mc = 3;
	static node[] nodes = new node[101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while (arr[r-1][c-1] != k && cnt <= 100) {
			if (mr >= mc) sortR(arr);
			else sortC(arr);
//			for (int i = 0; i < mr; i++) {
//				for (int j = 0; j < mc; j++)
//					System.out.print(arr[i][j]+" ");
//				System.out.println();
//			}
//			System.out.println("mr = "+mr+" mc = "+mc+" cnt = "+cnt);
//			System.out.println();
			cnt++;
		}
		if (cnt > 100) System.out.println(-1);
		else System.out.println(cnt);
	}
	
	static void sortR(int[][] arr) {
		int R = mr;
		int C = mc;
		for (int i = 0; i <= 100; i++)
			nodes[i] = new node(i);
		
		mc = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				nodes[arr[r][c]].num++;
			}
			nodes[0].num = 0;
			Arrays.sort(nodes, new Comparator<node>() {

				@Override
				public int compare(node o1, node o2) {
					if (o1.num == 0 && o2.num != 0) return 1;
					else if (o1.num != 0 && o2.num == 0) return -1;
					else if (o1.num == 0 & o2.num == 0) return o1.val - o2.val;
					if (o1.num == o2.num) return o1.val - o2.val;
					return o1.num - o2.num;
				}
			});
			int idx = 0;
			for (int i = 0; i <= 100 && idx < 100; i++) {
				if (nodes[i].num > 0) {
					arr[r][idx++] = nodes[i].val;
					if (idx < 100)
						arr[r][idx++] = nodes[i].num;
				}
			}
			
			for (int i = idx; i < 100; i++)
				arr[r][i] = 0;
			
			for (int i = 0; i <= 100; i++)
				nodes[i] = new node(i);
			
			mc = Math.max(mc, idx);
		}
	}
	
	static void sortC(int[][] arr) {
		int R = mr;
		int C = mc;
		for (int i = 0; i <= 100; i++)
			nodes[i] = new node(i);
		
		mr = 0;
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				nodes[arr[r][c]].num++;
			}
			nodes[0].num = 0;
			Arrays.sort(nodes, new Comparator<node>() {

				@Override
				public int compare(node o1, node o2) {
					if (o1.val == 0 & o2.val != 0) return 1;
					else if (o1.val != 0 && o2.val == 0) return -1;
					
					if (o1.num == 0 && o2.num != 0) return 1;
					else if (o1.num != 0 && o2.num == 0) return -1;
					
					if (o1.num == o2.num) return o1.val - o2.val;
					return o1.num - o2.num;
				}
			});
			
			int idx = 0;
			for (int i = 0; i <= 100 && idx < 100; i++) {
				if (nodes[i].num > 0) {
					arr[idx++][c] = nodes[i].val;
					if (idx < 100)
						arr[idx++][c] = nodes[i].num;
				}
			}
			
			for (int i = idx; i < 100; i++)
				arr[i][c] = 0;
			
			for (int i = 0; i <= 100; i++)
				nodes[i] = new node(i);
			
			mr = Math.max(mr, idx);
		}
	}
	
	static class node {
		int val = 0;
		int num = 0;
		
		public node() {}

		@Override
		public String toString() {
			return val + ", " + num;
		}

		public node(int val) {
			this.val = val;
		}
	}
}