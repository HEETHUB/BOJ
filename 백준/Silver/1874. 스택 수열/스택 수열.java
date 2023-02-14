import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		int idx = 1;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < N) {
			if (stack.isEmpty() || arr[i] > stack.peek()) {
				sb.append("+\n");
				stack.push(idx++);
			} else if (arr[i] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				i++;
			} else if (arr[i] < stack.peek()) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb);
	}
}