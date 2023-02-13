import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			StringBuilder sb = new StringBuilder();
			Queue<Integer> input = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			
			for (int i = 0; i < 8; i++) {
				input.offer(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 1;
			while (true) {
				int temp = input.poll() - idx;
				if (temp <= 0) {
					input.offer(0);
					break;
				}
				input.offer(temp);
				idx++;
				if (idx > 5) idx = 1;
			}
			
			for (int i = 0; i < 8; i++) sb.append(input.poll() + " ");
			
			System.out.println("#" + t + " " + sb.toString());
		}
	}
}