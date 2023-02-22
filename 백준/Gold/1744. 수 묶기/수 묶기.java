import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queuePlus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queueMinus = new PriorityQueue<>();
		int zero = 0;
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) zero++;
			else if (num == 1) ans++;
			else if (num > 1) queuePlus.add(num);
			else queueMinus.add(num);
		}
		
		while (queuePlus.size() > 1) 
			ans += queuePlus.poll()*queuePlus.poll();
		
		if (queuePlus.size() == 1) ans += queuePlus.poll();
		
		while (queueMinus.size() > 1)
			ans += queueMinus.poll()*queueMinus.poll();
		
		if (!queueMinus.isEmpty()) {
			if (zero == 0) ans += queueMinus.poll(); 
		}

		System.out.println(ans);
	}
}