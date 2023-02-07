import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String A = br.readLine();
		String B = br.readLine();
		int lenA = A.length();
		int lenB = B.length();
		
		int[][] dp = new int[lenA+1][lenB+1];
		char[] result = new char[Math.max(lenA, lenB)+1];
		int temp = 1;
		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		Stack<Character> st = new Stack<>();
		int idxA = lenA;
		int idxB = lenB;
		while (idxA > 0 && idxB > 0) {
			if (idxA==0 || idxB==0) break;
			if (dp[idxA][idxB] == dp[idxA-1][idxB])
				idxA--;
			else if (dp[idxA][idxB] == dp[idxA][idxB-1])
				idxB--;
			else {
				st.add(A.charAt(idxA-1));
				idxA--;
				idxB--;
			}
		}
		
		int ans = dp[lenA][lenB];
		bw.write(String.valueOf(ans));
		bw.newLine();
		while (!st.isEmpty())
			bw.write(st.pop());
		bw.flush();
		bw.close();
	}
}
