import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int[] arr = new int[num.length()];
		for (int i = 0; i < num.length(); i++)
			arr[i] = num.charAt(i) - '0';
		
		for (int i = 0; i <= num.length()-2; i++) {
			int min = i;
			for (int j = i; j <= num.length()-1; j++) {
				if (arr[j] < arr[min]) min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		for (int i = num.length()-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}