import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int[] temp;
	static int[][] map;
	static List<int[]> home, chicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		temp = new int[M];
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) home.add(new int[] {i, j});
				if (map[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		comb(0, 0);
		
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					min = Math.min(min, Math.abs(chicken.get(temp[j])[0] - home.get(i)[0]) + Math.abs(chicken.get(temp[j])[1] - home.get(i)[1]));
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			temp[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}
