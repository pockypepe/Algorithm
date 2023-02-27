import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] inputs = new int[K];
		
		long max = 0;
		long min = 1;
		
		for (int i = 0; i < K; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, inputs[i]);
		}
				
		while (min <= max) {
			long mid = (max + min) / 2;
			int cnt = 0;
			
			for (int i = 0; i < K; i++) {
				cnt += inputs[i] / mid;
			}
			if (cnt < N) max = mid - 1;
			else min = mid + 1;
		}
		
		System.out.println((max + min) / 2);
	}
}