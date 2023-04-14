import java.util.*;
import java.io.*;

public class Main {
	static int ans;
	static ArrayList<Integer> ansIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String text = br.readLine();
		String pattern = br.readLine();
		KMP(text, pattern);
		sb.append(ans+"\n");
		for (int idx : ansIdx)
			sb.append(idx+" ");
		System.out.println(sb);
	}
	
	private static int[] makeTable(String pattern) {
		int[] table = new int[pattern.length()];
		
		int idx = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				table[i] = ++idx;
			}
		}
		return table;
	}
	
	private static void KMP(String text, String pattern) {
		ans = 0;
		ansIdx = new ArrayList<>();
		int[] table = makeTable(pattern);
		
		int idx = 0;
		for (int i = 0; i < text.length(); i++) {
			while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if (text.charAt(i) == pattern.charAt(idx)) {
				if (idx == pattern.length()-1) {
					ans++;
					ansIdx.add(i-idx+1);
					idx = table[idx];
				}
				else idx++;
			}
		}
	}
}