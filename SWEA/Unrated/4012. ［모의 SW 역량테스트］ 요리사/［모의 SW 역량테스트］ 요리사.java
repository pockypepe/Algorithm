import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, R, ans;
	static boolean[] visited;
	static int[] inputs, numbers;
	static int[][] synergy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			
			synergy = new int[N][N];
			visited = new boolean[N];
			inputs = new int[N];
			numbers = new int[R];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) inputs[i] = i;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int sum1 = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					sum1 += synergy[numbers[i]][numbers[j]];
				}
			}
			int[] other = new int[R];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;
				other[idx++] = i;
			}
			int sum2 = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					sum2 += synergy[other[i]][other[j]];
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
}
