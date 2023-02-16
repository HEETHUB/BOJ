import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] sketch = new int[100][100];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int left = sc.nextInt();
			int under = sc.nextInt();
			for (int c = left; c < left+10; c++) {
				for (int r = 90-under; r < 100-under; r++) {
					if (sketch[r][c] == 0) {
						sketch[r][c] = 1;
						ans++;
					}	
				}
			}
		}
		System.out.println(ans);
		
	}
}