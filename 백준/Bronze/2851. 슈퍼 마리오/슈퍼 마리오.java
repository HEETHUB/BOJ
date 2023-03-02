import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mush= new int[11];
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			mush[i] = mush[i-1] + Integer.parseInt(br.readLine());
			if (Math.abs(mush[i] - 100) <= Math.abs(100 - score))
				score = mush[i];
		}
		
		System.out.println(score);
	}
}