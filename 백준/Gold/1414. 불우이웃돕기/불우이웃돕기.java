import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static PriorityQueue<edge> edges;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edges = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				int w = 0;
				if (Character.isDigit(line.charAt(j))) w = 0;
				else if (line.charAt(j) >= 'a') w = line.charAt(j)-'a'+1;
				else w = line.charAt(j)-'A'+27;
				if (w > 0)
					edges.add(new edge(i, j, w));
			}
		}
		int ans = 0;
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = i;
		while (!edges.isEmpty()) {
			edge cur = edges.poll();
			
			if (find(cur.s) != find(cur.e)) union(cur.s, cur.e);
			else ans += cur.w;
		}
		if (isLinked()) System.out.println(ans);
		else System.out.println(-1);
	}
	
	private static boolean isLinked() {
		for (int i = 0; i < N-1; i++) {
			if (find(i) != find(i+1)) return false;
		}
		return true;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) arr[b] = a;
	}

	private static int find(int a) {
		if (a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}

	static class edge implements Comparable<edge>{
		int s;
		int e;
		int w;
		
		public edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "[" + s + ", " + e + ", " + w + "]";
		}
	}
}