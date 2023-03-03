import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, R, C, L;
	// 1~7번까지 상 하 좌 우 순
	static int[][] dx = {{}, {-1, 1, 0, 0}, {-1, 1, 0, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {-1, 0, 0, 0}};
	static int[][] dy = {{}, {0, 0, -1, 1}, {0, 0, 0, 0}, {0, 0, -1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, -1, 0}, {0, 0, -1, 0}};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			moveCriminal(R, C);
			
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) count++;
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}

	private static void moveCriminal(int x, int y) {
		int type = map[x][y];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, type, 0});
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			if (current[3] == L) break;
			
			if (visited[current[0]][current[1]]) continue;
			visited[current[0]][current[1]] = true;
			
			
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[current[2]][d];
				int ny = current[1] + dy[current[2]][d];
				if (isInRange(nx, ny) && !visited[nx][ny] 
						&& map[nx][ny] != 0 && checkConnect(current[2], map[nx][ny], d)) {
					q.offer(new int[] {nx, ny, map[nx][ny], current[3] + 1});
				}
			}
		}
		
	}
	// 상 하 좌 우
	// current와 next가 각각 이 배열에 있으면 연결되어 있음
	static int[][] connectCurr = {{1, 2, 4, 7}, {1, 2, 5, 6}, {1, 3, 6, 7}, {1, 3, 4, 5}};
	static int[][] connectNext = {{1, 2, 5, 6}, {1, 2, 4, 7}, {1, 3, 4, 5}, {1, 3, 6 ,7}};
	
	private static boolean checkConnect(int current, int next, int way) {
		int isCurrent = 0, isNext = 0;
		for (int i = 0; i < 4; i++) {
			if (current == connectCurr[way][i]) isCurrent++;
			if (next == connectNext[way][i]) isNext++;
		}
		if (isCurrent != 0 && isNext != 0) return true;
		return false;
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
}
