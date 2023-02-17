import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int cycle = 1500000;
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong()%cycle;
		
		int[] fibo = new int[cycle+1];
		fibo[1] = 1;
		fibo[2] = 1;
		for (int i = 3; i <= cycle; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2])%1000000;
		}
		
		System.out.println(fibo[(int)n]);
	}
}