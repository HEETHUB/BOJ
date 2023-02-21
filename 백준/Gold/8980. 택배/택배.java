import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을 수
		int C = Integer.parseInt(st.nextToken()); // 트럭 용량
		int M = Integer.parseInt(br.readLine()); // 박스 개수
		
		int[][] boxes = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				boxes[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(boxes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if ((o1[1]-o1[0]) == (o2[1]-o2[0]))
					return o1[0] - o2[0];
				return (o1[1]-o1[0]) - (o2[1]-o2[0]);
			}
		});
		
//		for (int[] box : boxes) System.out.println(Arrays.toString(box));
		
		int sum = 0;
		int[] truck = new int[N+1];
		for (int[] box : boxes) {
			int temp = box[2]; // temp = 짐 용량
			if (box[1] - box[0] == 1) {
				sum += box[2];
				truck[box[0]] += temp;
			} else {
				for (int i = box[0]; i < box[1]; i++) 
					if (truck[i] + temp > C) temp = C - truck[i];
				sum += temp;
				for (int i = box[0]; i < box[1]; i++) 
					truck[i] += temp;
			}
		}
		
		System.out.println(sum);
	}
}