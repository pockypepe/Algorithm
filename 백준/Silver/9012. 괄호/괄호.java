import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int t = 0; t < n; t++) {
			String[] input = br.readLine().split("");
			Stack<String> s = new Stack<>();
			s.push(input[0]);
			for (int i = 1; i < input.length; i++) {
				if (s.isEmpty()) { // 다 빠져서 비어있으면 그냥 push
					s.push(input[i]);
					continue;
				}
				if ((s.peek() + input[i]).equals("()")) { // ()의 모양이 나오면 pop하고 넘기기
					s.pop();
					continue;
				}
				s.push(input[i]);
			}
			if (s.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}