import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		int K = Integer.parseInt(br.readLine());
		
		Map<Character, BigInteger> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char temp = words[i].charAt(j);
				if (temp == 'Z' || map.containsKey(temp)) continue;
				BigInteger num = BigInteger.ZERO;
				int diff = 0;
				if (Character.isDigit(temp)) diff = 35 - (temp-'0');
				else diff = 35 - (temp-'7');
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < words[r].length(); c++) {
						if (words[r].charAt(c) == temp)
							num = num.add(BigInteger.valueOf(diff).multiply(BigInteger.valueOf(36).pow(words[r].length()-1-c)));
					}
				}
				map.put(temp, num);
			}
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if (o1.num.compareTo(o2.num) == -1) return 1;
				else if (o1.num.compareTo(o2.num) == 1) return -1;
				return 0;
			}
		});
		for (Character c : map.keySet())
			pq.add(new node(c, map.get(c)));
//		System.out.println(map.toString());
		for (int i = 0; i < K && !pq.isEmpty(); i++) {
			char temp = pq.poll().c;
			for (int j = 0; j < N; j++) {
				String str = "";
				for (int k = 0; k < words[j].length(); k++) {
					if (words[j].charAt(k) == temp)
						str += 'Z';
					else str += words[j].charAt(k);
				}
				words[j] = str;
			}
		}
		
//		for (String w : words) System.out.println(w);
//		System.out.println("-----------------");
		String ans = "";
		for (String w : words) {
			ans = add36(ans, w);
//			System.out.println(ans);
		}
		System.out.println(ans);
	}
	
	private static String add36(String num1, String num2) {
		char[] chars = {'0','1','2','3','4','5','6','7','8','9'
						,'A','B','C','D','E','F','G','H','I','J'
						,'K','L','M','N','O','P','Q','R','S','T'
						,'U','V','W','X','Y','Z'};
		String res = "";
		int idx = 1;
		boolean up = false;
		while (idx <= num1.length() && idx <= num2.length()) {
			int temp = 0;
			if (up) temp++;
			up = false;
			char char1 = num1.charAt(num1.length()-idx);
			char char2 = num2.charAt(num2.length()-idx);
			if (Character.isDigit(char1)) temp += char1 - '0';
			else temp += char1 - '7';
			if (Character.isDigit(char2)) temp += char2 - '0';
			else temp += char2 - '7';
			if (temp/36 > 0) up = true;
			res += chars[temp%36];
			idx++;
		}
		
		while (idx <= num1.length()) {
			int temp = 0;
			if (up) temp++;
			up = false;
			char char1 = num1.charAt(num1.length()-idx);
			if (Character.isDigit(char1)) temp += char1 - '0';
			else temp += char1 - '7';
			if (temp/36 > 0) up = true;
			res += chars[temp%36];
			idx++;
		}
		
		while (idx <= num2.length()) {
			int temp = 0;
			if (up) temp++;
			up = false;
			char char2 = num2.charAt(num2.length()-idx);
			if (Character.isDigit(char2)) temp += char2 - '0';
			else temp += char2 - '7';
			if (temp/36 > 0) up = true;
			res += chars[temp%36];
			idx++;
		}
		
		if (up) res += '1';
		
		String result = "";
		for (int i = 1; i <= res.length(); i++) {
			result += res.charAt(res.length()-i);
		}
		return result;
	}
	
	static class node{
		char c;
		BigInteger num;
		public node(char c, BigInteger num) {
			this.c = c;
			this.num = num;
		}
	}
}