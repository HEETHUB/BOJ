import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eq = br.readLine();
		
		String ans = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < eq.length(); i++) {
			switch (eq.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(eq.charAt(i)))
					ans += stack.pop();
				stack.push(eq.charAt(i));
				break;
			case '(':
				stack.push(eq.charAt(i));
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') 
					ans += stack.pop();
				stack.pop();
				break;
			default:
				ans += eq.charAt(i);
			}
		}
		while (!stack.isEmpty()) ans += stack.pop();
		System.out.println(ans);
	}
	
	private static int priority(char c) {
		if (c == '(' || c == ')') return 0;
		else if (c == '*' || c == '/') return 2;
		else if (c == '+' || c == '-') return 1;
		return -1;
	}
}