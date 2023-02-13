import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean checkPrime(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int[] first = {2,3,5,7};
		int[] next = {1,3,7,9};
		int div = 1;
		for (int i = 1; i < N; i++) div *= 10;
		Queue<Integer> queue = new LinkedList<>();
		for (int f : first) queue.offer(f);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			if (temp/div >= 1) {
				bw.write(String.valueOf(temp)+"\n");
				continue;
			}
			for (int n : next) {
				if (checkPrime(temp*10+n))
					queue.offer(temp*10+n);
			}
		}
		bw.flush();
		bw.close();
	}
}