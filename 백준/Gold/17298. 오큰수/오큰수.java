import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[N];
		Stack<Integer> stack = new Stack<>();
		for (int i = N-1; i >= 0; i--) {
			while (true) {
				if (stack.isEmpty()) {
					ans[i] = -1;
					stack.push(A[i]);
					break;
				} else if (stack.peek() > A[i]){
					ans[i] = stack.peek();
					stack.push(A[i]);
					break;
				} else stack.pop();
			}
		}
		
		for (int a : ans)
			bw.write(String.valueOf(a)+" ");
		bw.flush();
		bw.close();
	}
}