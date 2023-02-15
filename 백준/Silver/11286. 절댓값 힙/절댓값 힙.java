import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) != Math.abs(o2)) {
				return Math.abs(o1) - Math.abs(o2);
			}else {
				return o1 - o2;
			}
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] input = new int[n];
		
		for (int i = 0; i < n; i++) input[i] = Integer.parseInt(br.readLine());
		
		int idx = 0;
		while (idx < n) {
			if (input[idx] != 0) pq.offer(input[idx]);
			else {
				if (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
			idx++;
		}
		
		System.out.println(sb.toString());
	}
}
