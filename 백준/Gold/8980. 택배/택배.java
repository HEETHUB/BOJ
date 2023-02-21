import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을 수
		int C = Integer.parseInt(st.nextToken()); // 트럭 용량
		int M = Integer.parseInt(br.readLine()); // 박스 개수

		int[][] boxes = new int[M][3];
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				boxes[i][j] = Integer.parseInt(st.nextToken());
			set.add(boxes[i][1] - boxes[i][0]);
		}
		Integer[] arr = set.toArray(new Integer[0]);

		Arrays.sort(boxes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

//		for (int[] box : boxes) System.out.println(Arrays.toString(box));

		int sum = 0;
		int[] truck = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			truck[i] = C;
		
		
		for (int[] box : boxes) {
			int temp = C;
			for (int i = box[0]; i < box[1]; i++)
				if (temp > Math.min(truck[i], box[2])) 
					temp = Math.min(truck[i], box[2]);
			for (int i = box[0]; i < box[1]; i++)
				truck[i] -= temp;
			sum += temp;
//			System.out.println(temp+" "+sum+" "+Arrays.toString(box)+"\n"+Arrays.toString(truck));
		}

		System.out.println(sum);
	}
}