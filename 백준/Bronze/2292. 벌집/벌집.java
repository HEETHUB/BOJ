import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1;
		int idx = 1;
		while (N > 0) 
			N -= 6 * idx++;
		System.out.println(idx);
	}
}