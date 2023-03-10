import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int [N + 1][N + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken())  + map[i][j - 1];
				}
			}
			
			int max = 0;
			
			for (int i = 1; i <= N - M + 1; i++) {
				for (int j = 1; j <= N - M + 1; j++) {
					int sum = 0;
					for (int k = i; k <= i + M - 1; k++) {
						sum += map[k][j + M - 1] - map[k][j - 1];
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}