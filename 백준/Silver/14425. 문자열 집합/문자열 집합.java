import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NM.nextToken());
		int M = Integer.parseInt(NM.nextToken());
		tNode root = new tNode();
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			tNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (cur.next[c-'a'] == null) cur.next[c-'a'] = new tNode();
				cur = cur.next[c-'a'];
				if (j == word.length()-1) cur.isEnd = true;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			String word = br.readLine();
			tNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (cur.next[c-'a'] == null) break;
				cur = cur.next[c-'a'];
				if (j == word.length()-1 && cur.isEnd) ans++;
			}
		}
		System.out.println(ans);
	}
	
	static class tNode{
		tNode[] next = new tNode[26];
		boolean isEnd;
	}
}