import java.io.*;
import java.util.*;

public class Solution {
	static int N, coreCnt, wireLength;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int[][] map;
	static List<Core> coreList;
	
	static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void dfs(int idx, int cnt, int length) {
		if (idx == coreList.size()) {
			if (coreCnt < cnt) {
				coreCnt = cnt;
				wireLength = length;
			}
			else if (cnt == coreCnt) wireLength = Math.min(wireLength, length);
			return;
		}
		
		Core core = coreList.get(idx);
		
		for (int d = 0; d < 4; d++) {
			int count = 0;
			int nx = core.x;
			int ny = core.y;
			
			while (true) {
				nx += dx[d];
				ny += dy[d];
				// 범위를 벗어났다는 의미는 정상적으로 전선을 연결했음을 의미
				if (!isInRange(nx, ny)) break;
				// 1을 만났다는 의미는 겹침을 의미
				if (map[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			// count가 0이면 겹쳤으므로 다음 core로 넘기기
			if (count == 0) {
				dfs(idx + 1, cnt, length);
			} else {
				// 맵에 전선 표시
				fill(core, count, d, 1);
				// 다음 core로 넘어가기
				dfs(idx + 1, cnt + 1, length + count);
				// 맵에 전선 표시한거 없애기
				fill(core, count, d, 0);
			}
		}
	}
	
	private static void fill(Core core, int count, int way, int num) {
		int fillX = core.x;
		int fillY = core.y;
		
		for (int i = 0; i < count; i++) {
			fillX += dx[way];
			fillY += dy[way];
			map[fillX][fillY] = num;
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			wireLength = Integer.MAX_VALUE;
			coreCnt = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1 && map[i][j] == 1) {
						coreList.add(new Core(i, j));
					}
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + tc + " " + wireLength);
		}
	}
}