import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][2];
		int ans = 1000000001;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < (1 << N); i++) {
			int s = 1;
			int t = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				s *= data[j][0];
				t += data[j][1];
			}
			ans = Math.min(ans, Math.abs(s - t));
		}
		
		System.out.println(ans);
	}
}
