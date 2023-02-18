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
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (arr[r - 1][c - 1] != k && cnt <= 100) {
			sort(arr);
			cnt++;
		}
		
		if (cnt > 100)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}
	
	static void sort(int[][] arr) {
		// N -> maximum index for loop
		int N = Math.max(mr, mc);
		
		// initialize nodes 
		for (int i = 0; i <= 100; i++)
			nodes[i] = new node(i);
		
		int temp = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// mr >= mc -> operate R
				// mr < mc => operate C
				if (mr >= mc) nodes[arr[x][y]].num++;
				else nodes[arr[y][x]].num++;
			}
			nodes[0].num = 0; // 0.num should be 0 
			
			// sort nodes before filling arr
			Arrays.sort(nodes, new Comparator<node>() {
				@Override
				public int compare(node o1, node o2) {
					if (o1.num * o2.num == 0) return o2.num - o1.num; 
					if (o1.num == o2.num) return o1.val - o2.val;
					return o1.num - o2.num;
				}
			});
			
			// fill arr with nodes order
			int idx = 0;
			for (int i = 0; i <= 100 && idx < 100; i++) {
				if (nodes[i].num > 0) {
					if (mr >= mc) arr[x][idx++] = nodes[i].val;
					else arr[idx++][x] = nodes[i].val;
					if (idx < 100) {
						if (mr >= mc) arr[x][idx++] = nodes[i].num;
						else arr[idx++][x] = nodes[i].num;
					}
				}
			}
			
			// initialize both nodes and arr
			for (int i = idx; i < 100; i++) {
				if (mr >= mc) arr[x][i] = 0;
				else arr[i][x] = 0;
			}
			
			for (int i = 0; i <= 100; i++)
				nodes[i] = new node(i);
			
			temp = Math.max(temp, idx);
		}
		
		// refactoring mr or mc with temp
		if (mr >= mc) mc = temp;
		else mr = temp;
	}

	static class node {
		int val = 0;
		int num = 0;

		public node() {}

		public node(int val) {
			this.val = val;
		}
	}
}