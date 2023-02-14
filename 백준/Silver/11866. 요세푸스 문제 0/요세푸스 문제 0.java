import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) q.offer(i);
		
		sb.append("<");
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt % k == 0) sb.append(q.poll()).append(", ");
			else q.offer(q.poll());
			cnt++;
		}
		sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(" "), ">");
		System.out.println(sb.toString());
	}
}