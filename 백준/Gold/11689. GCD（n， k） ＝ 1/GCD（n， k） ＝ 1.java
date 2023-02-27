import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long ans = n;
		
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				ans -= ans/i;
				while (n%i == 0) n /= i;
			}
		}
		
		if (n > 1) ans -= ans/n;
		
		System.out.println(ans);
	}
}