import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++)	{
			String[] input = br.readLine().split(" ");
			
			switch(input[0]) {
			case "push" : s.push(input[1]); break;
			case "pop" : 
				if (s.isEmpty()) sb.append(-1).append("\n");
				else sb.append(s.pop()).append("\n");
				break;
			case "size" : sb.append(s.size()).append("\n"); break;
			case "empty" : 
				if (s.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "top" :
				if (s.isEmpty()) sb.append(-1).append("\n");
				else sb.append(s.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}