import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t < 11; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) list.add(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				
				st.nextToken();
				
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < num; j++) {
					list.add(idx + j, st.nextToken());
				}
			}
			
			for (int i = 0; i < 10; i++) sb.append(list.get(i) + " ");

			System.out.println("#" + t + " " + sb.toString());

		}
	}
}