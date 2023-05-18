import java.util.*;

import java.io.*;

public class Main {
	static Stack<Character> temp = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String exp = br.readLine();
		Stack<Character> stack = new Stack<>();
		int len = exp.length();
		for (int i = 0; i < word.length(); i++) {
			stack.add(word.charAt(i));
			if (len >= 1 && word.charAt(i) == exp.charAt(len-1)) {
				doPop(stack, exp);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) sb.append(stack.pop());
		sb.reverse();
		if (sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
		
	}

	private static void doPop(Stack<Character> stack, String exp) {
		int idx = exp.length()-1;
		while (idx >= 0) {
			if (!stack.isEmpty() && stack.peek() == exp.charAt(idx)) {
				temp.add(stack.pop());
				idx--;
			} else {
				while (!temp.isEmpty()) {
					stack.add(temp.pop());
				}
				break;
			}
		}
		temp.clear();
	}
}