import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			int cur = queue.poll();
			queue.offer(cur);
		}
		
		System.out.println(queue.peek());
	}
}
