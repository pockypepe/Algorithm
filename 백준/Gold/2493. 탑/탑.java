import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> s = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		s.push(Integer.MAX_VALUE);
		idx.push(0);
		int[] input = new int[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			
			while (s.peek() < input[i]) {
				s.pop();
				idx.pop();
			}
			sb.append(idx.peek()).append(" ");
			s.push(input[i]);
			idx.push(i + 1);
		}
		
		System.out.println(sb.toString());
	}
}
