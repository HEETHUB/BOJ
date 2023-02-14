import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[N];
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 처음에는 항상 스택이 비어있으므로 최초 값을 push
		for (int i = 1; i < N; i++) {
			// stack이 비어있지 않고 현재 수열이 스택의 top index가 가리키는 수열보다 클 경우
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				ans[stack.pop()] = A[i]; // 정답 배열에 오큰수를 현재 수열로 저
			}
			stack.push(i); // 신규 데이터 push
		}
		while (!stack.isEmpty())
			ans[stack.pop()] = -1;
		
		for (int a : ans)
			sb.append(a).append(" ");
		System.out.println(sb);
	}
}