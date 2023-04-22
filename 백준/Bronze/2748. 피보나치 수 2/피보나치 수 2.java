import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	    long[] fibo = new long[N+1];
        fibo[1] = 1;
        for (int i = 2; i <= N; i++)
            fibo[i] = fibo[i-2] + fibo[i-1];
        System.out.println(fibo[N]);
	}
}