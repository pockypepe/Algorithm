import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H, ans;
	static int[] numbers; // 중복순열 담을 배열
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken()); // 열
			H = Integer.parseInt(st.nextToken()); // 행
			map = new int[H][W];
			numbers = new int[N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			shoot(map);
			return;
		}
		for (int i = 0; i < W; i++) {
			numbers[cnt] = i;
			perm(cnt + 1);
		}
	}

	private static void shoot(int[][] beforeMap) {
		int[][] afterMap = copyMap(beforeMap);
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int startX = 0;
			for (int j = 0; j < H; j++) {
				if (afterMap[j][numbers[i]] != 0) {
					startX = j;
					break;
				}
			}
			
			bomb(startX, numbers[i], afterMap);
			remap(afterMap);
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (afterMap[i][j] != 0) count++;
			}
		}
		
		ans = Math.min(ans, count);
	}
	
	private static void remap(int[][] map) {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < W; i++) {
			int count = 0;
			for (int j = 0; j < H; j++) {
				if (map[j][i] == 0) {
					count++;
					continue;
				}
				q.offer(map[j][i]);
			}
			
			for (int j = 0; j < H; j++) map[j][i] = 0;
			
			for (int j = count; j < H; j++) map[j][i] = q.poll();
		}
	}

	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	private static void bomb(int startX, int startY, int[][] map) {
		int range = map[startX][startY];
		map[startX][startY] = 0; // 해당자리 벽돌 없앰
		
		for (int d = 0; d < 4; d++) {
			int nx = startX;
			int ny = startY;
			for (int i = 0; i < range - 1; i++) {
				nx += dx[d];
				ny += dy[d];
				if (isInRange(nx, ny) && map[nx][ny] != 0) bomb(nx, ny, map);
			}
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < H && 0 <= ny && ny < W;
	}

	private static int[][] copyMap(int[][] beforeMap) {
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = beforeMap[i][j];
			}
		}
		return copy;
	}
}