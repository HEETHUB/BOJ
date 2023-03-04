import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			BigInteger temp = BigInteger.ZERO;
			
			for (int j = 0; j < N; j++) 
				temp = temp.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
			
			if (temp.compareTo(BigInteger.ZERO) == 0) sb.append("0\n");
			else if (temp.compareTo(BigInteger.ZERO) < 0) sb.append("-\n");
			else sb.append("+\n");
		}
		System.out.println(sb);
	}
}