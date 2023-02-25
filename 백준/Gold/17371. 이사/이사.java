import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double[][] nums;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new double[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
			
		double min = 2000000000;
		int minIdx = -1;
		
		for (int i = 0; i < N; i++) {
			double max = -1;
			int temp = -1;
			for (int j = 0; j < N; j++) {
				if (dist(nums[i], nums[j]) > max) {
					max = dist(nums[i], nums[j]);
					temp = i;
				}
			}
			if (max < min) {
				min = max;
				minIdx = temp;
			}
		}
		System.out.println(nums[minIdx][0]+" "+nums[minIdx][1]);
	}
		
	private static double dist(double[] start, double[] end) {
		double X = (start[0] - end[0])*(start[0] - end[0]);
		double Y = (start[1] - end[1])*(start[1] - end[1]);
		return X+Y;
	}
}