import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<String> q = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		String last = "";
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			
			switch (input[0]) {
			case "push":
				q.offer(input[1]);
				last = input[1];
				break;
			case "pop":
				if (q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if (q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if (q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
				break;
			case "back":
				if (q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(last).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}