import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] input = new int[N + 1];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		
		int idx = 0;
		s.push(0);

		
		int i = 1;
		while (idx < N) {
			if (input[idx] == s.peek()) {
				s.pop();
				sb.append("-").append("\n");
				idx++;
			} else {
				s.push(i);
				sb.append("+").append("\n");
				i++;
				if (s.peek() > input[idx]) {
					sb.setLength(0);
					sb.append("NO");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}