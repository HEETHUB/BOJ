import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dwarf = new int[9];
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if (sum - (dwarf[i]+dwarf[j]) == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j) continue;
						bw.write(String.valueOf(dwarf[k]));
						bw.newLine();
					}
					break;
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
