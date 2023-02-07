import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		int[] dir = new int[6];
		int[] len = new int[6];
		int h = 0;
		int w = 0;
		
		for (int k = 0; k < 6; k++) {
			dir[k] = sc.nextInt();
			len[k] = sc.nextInt();
			if (map.containsKey(dir[k]))
				map.remove(dir[k]);
			else map.put(dir[k], len[k]);
		}
		
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				if (dir[i] - dir[5] == 2 || dir[i] - dir[5] == -3 || dir[i] - dir[5] == -1) {
					h = len[i];
					w = len[5];
				}
			} else {
				if (dir[i] - dir[i-1] == 2 || dir[i] - dir[i-1] == -3 || dir[i] - dir[i-1] == -1) {
					h = len[i];
					w = len[i-1];
				}
			}
		}
		int ans = 1;
		for (int n : map.keySet())
			ans *= map.get(n);
		
		ans -= h*w;
		ans *= K;
		System.out.println(ans);
	}
}