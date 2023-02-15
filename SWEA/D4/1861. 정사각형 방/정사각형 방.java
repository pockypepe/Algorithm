import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int pos = 0;
			int result = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int[] ans = bfs(i, j);
					if (ans[1] > result) {
						pos = ans[0];
						result = ans[1];
						continue;
					}
					if (ans[1] == result) {
						pos = Math.min(pos, ans[0]);
						result = ans[1];
						continue;
					}
				}
			}
			System.out.println("#" + t + " " + pos + " " + result);
		}
	}

	private static int[] bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x, y});
		
		visited = new boolean[N][N];
		
		int[] ans = new int[] {0, 0};
		
		int count = 0;
		while(!q.isEmpty()) {
			int[] cnt = q.poll();
			
			if (visited[cnt[0]][cnt[1]]) continue;
			
			visited[cnt[0]][cnt[1]] = true;
			count += 1;
			
			for (int i = 0; i < 4; i++) {
				int nx = cnt[0] + dx[i];
				int ny = cnt[1] + dy[i];
				
				if (isRange(nx, ny) && map[cnt[0]][cnt[1]] - map[nx][ny] == -1 && !visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
				}
			}
		}
		ans[0] = map[x][y];
		ans[1] = count;
		return ans;
	}

	private static boolean isRange(int nx, int ny) {
		return (0 <= nx && nx < N) && (0 <= ny && ny < N);
	}
}