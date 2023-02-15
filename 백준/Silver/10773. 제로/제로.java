import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		s.push(0);
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			switch (num) {
			case 0: {
				s.pop();
				break;
			}
			default:
				s.push(num);
			}
		}
		
		int sum = 0;
		while (!s.isEmpty()) {
			sum += s.pop();
		}
		
		System.out.println(sum);
	}
}