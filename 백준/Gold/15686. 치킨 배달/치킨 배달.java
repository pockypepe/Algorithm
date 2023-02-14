import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, min, ans;
	static int[][] temp;
	static List<int[]> chicken, home;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][n + 1];
		// 1과 2 위치 따로 저장
		home = new ArrayList<>();
		chicken = new ArrayList<>();
			
		ans = Integer.MAX_VALUE;
		temp = new int[m][2]; // 조합으로 뽑힌 2의 위치
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 1과 2 위치 따로 저장
				if (map[i][j] == 1) home.add(new int[]{i, j});
				if (map[i][j] == 2) chicken.add(new int[]{i, j});
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) { // 치킨집 조합
		if (cnt == m) {
			int com = 0;
			for (int i = 0; i < home.size(); i++) {
				min = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					// chicken과 home의 최소 거리
					min = Math.min(min, Math.abs(temp[j][0] - home.get(i)[0]) + Math.abs(temp[j][1] - home.get(i)[1]));
				}
				// chicken과 home의 최소거리의 합 = 치킨 거리
				com += min;
			}
			ans = Math.min(com, ans); // 치킨 거리 최소값 구하기
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			temp[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);
		}
	}
}