import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
						if (arr[j] == 0)
							arr[j] = 1;
						else
							arr[j] = 0;
					}
				}
			}
			if (gender == 2) {
				int k = 0;
				while (true) {
					if (number + k -1 >= N || number - k -1 < 0)
						break;
					if (arr[number - 1 - k] == arr[number - 1 + k]) {
						if (arr[number - 1 - k] == 1) {
							arr[number - 1 - k] = 0;
							arr[number - 1 + k] = 0;
							k++;
						} else if (arr[number - 1 - k] == 0) {
							arr[number - 1 - k] = 1;
							arr[number - 1 + k] = 1;
							k++;
						}
					}
					else
						break;
				}
			}

		}
		for(int i =0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			if ((i+1)%20 == 0) System.out.print("\n");
		}
	}
}