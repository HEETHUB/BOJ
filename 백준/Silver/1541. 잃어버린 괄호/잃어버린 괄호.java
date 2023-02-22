import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eq = br.readLine();
		int ans = 0;
		
		String[] nums1 = eq.split("-");
		for (int i = 0; i < nums1.length; i++) {
			int temp = 0;
			String[] now = nums1[i].split("[+]");
			for (int j = 0; j < now.length; j++) 
				temp += Integer.parseInt(now[j]);
			if (i == 0) ans += temp;
			else ans -= temp;
		}

		System.out.println(ans);
	}
}