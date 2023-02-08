import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(numbers[j] - numbers[i - 1] + " \n");
		}
		
		System.out.println(sb.toString());
	}
}