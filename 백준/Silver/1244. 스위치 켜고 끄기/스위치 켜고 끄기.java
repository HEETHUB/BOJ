import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		int studentNumber = sc.nextInt();
		int gender;
		int number;
		for (int i = 0; i < studentNumber; i++) {
			gender = sc.nextInt();
			number = sc.nextInt();
			if (gender == 1) {
				for (int j = 0; j < N; j++) {
					if ((j + 1) % number == 0) {
						change(arr, j);
					}
				}
			} else if (gender == 2) {
				change(arr, number - 1);
				for (int k = 1; number - 1 + k < arr.length && number - 1 - k >= 0; k++) {
					if (arr[number - 1 + k] == arr[number - 1 - k]) {
						change(arr, number - 1 - k);
						change(arr, number - 1 + k);
					} else
						break;
				}
			}

		}
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
			if ((i + 1)%20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void change(int[] arr, int i) {
		if (arr[i] == 0)
			arr[i] = 1;
		else
			arr[i] = 0;
	}
}