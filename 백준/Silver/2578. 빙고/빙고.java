import java.util.Scanner;

public class Main {
	static int cnt;
	static int[][] arr;
	static int[] arr1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[5][5];
		arr1 = new int[25];
		for (int n = 0; n < 5; n++) {
			for (int m = 0; m < 5; m++) {
				arr[n][m] = sc.nextInt();
			}
		}
		for (int n = 0; n < 25; n++) {
			arr1[n] = sc.nextInt();
		}
		int a = 0;
		cnt = 0;
		while (cnt < 3) {
			for (int i = 0; i < 25; i++) {
				check(arr1[i]);
				if (cnt >= 3) {
					System.out.println(i + 1);
					return;
				}
			}
		}

	}

	private static void check(int num) {
		cnt = 0;
		a: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (num == arr[i][j]) {
					arr[i][j] = -1;
					break a;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] != -1) {
					break;
				}
				if (j == 4) {
					cnt++;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != -1) {
					break;
				}
				if (j == 4) {
					cnt++;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (arr[i][i] != -1) {
				break;
			}
			if (i == 4) {
				cnt++;
			}
		}
		 for (int i = 0; i < 5; i++) {
			if (arr[i][4 - i] != -1) {
				break ;
			}
			if (i == 4) {
				cnt++;
			}
		}
		return;
	}
}