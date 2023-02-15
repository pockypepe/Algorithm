import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			Stack<String> s = new Stack<>();
			String[] input = br.readLine().split("");
			s.push("0");
			
			if (input.length == 1 && input[0].equals(".")) break;
			
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case ")": 
					if ((s.peek() + input[i]).equals("()")) s.pop();
					else s.push(input[i]);
					break;
				case "(" :
					s.push(input[i]);
					break;
				case "[" :
					s.push(input[i]);
					break;
				case "]" :
					if ((s.peek() + input[i]).equals("[]")) s.pop();
					else s.push(input[i]);
				}
			}
			
			if (s.size() == 1) System.out.println("yes");
			else System.out.println("no");
		}
		
	}
}