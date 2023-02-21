import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] flowers;
	static int ans = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flowers = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int month1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int month2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
			flowers[i][0] = DateToNum(month1, day1);
			flowers[i][1] = DateToNum(month2, day2);
		}
		
		Arrays.sort(flowers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			}
		});
		
		if (flowers[0][0] > DateToNum(3, 1)) System.out.println(0);
		else {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (flowers[i][0] > DateToNum(3, 1)) break;
				if (flowers[i][1] > flowers[idx][1]) idx = i;
			}
			
			int cnt = 1;
			while (flowers[idx][1] < DateToNum(12, 1)) {
				if (idx == nextIdx(idx) || idx == N-1) {
					cnt = 0;
					break;
				}
				idx = nextIdx(idx);
				cnt++;
			}
			System.out.println(cnt);
		}
	}
	
	private static int nextIdx(int idx) {
		int next = idx;
		for (int i = idx+1; i < N; i++) {
			if (flowers[i][0] > flowers[idx][1]) break;
			if (flowers[i][1] > flowers[next][1])
				next = i;
		}
		return next;
	}

	private static int DateToNum(int month, int day) {
		int[] months = {0, 31,28,31,30, 31,30, 31,31,30,31,30,31};
		int ans = 0;
		for (int i = 0; i < month; i++)
			ans += months[i];
		ans += day;
		return ans;
	}
}