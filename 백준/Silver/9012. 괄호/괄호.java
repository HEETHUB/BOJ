import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String indent = br.readLine();
			boolean ans = true;
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < indent.length(); i++) {
				if (indent.charAt(i) == '(')
					stack.push(1);
				else {
					if (stack.isEmpty()) {
						ans = false;
						break;
					}
					else 
						stack.pop();
				}
			}
			if (stack.isEmpty() && ans) bw.write("YES");
			else bw.write("NO");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
