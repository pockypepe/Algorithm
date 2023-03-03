import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int[][] map, distance;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			
			map = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
			
			for (int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = input[j] - '0';
				}
			}
			
			distance[0][0] = 0;
			moveTank(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void moveTank(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
	
		pq.offer(new int[] {x, y, 0});
		
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			
			if (current[0] == N -1 && current[1] == N - 1) {
				ans = current[2];
				break;
			}
			
			if (visited[current[0]][current[1]]) continue;
			visited[current[0]][current[1]] = true;
			
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				if (isInRange(nx, ny) && distance[nx][ny] > current[2] + map[nx][ny]) {
					distance[nx][ny] = current[2] + map[nx][ny];
					pq.offer(new int[] {nx, ny, current[2] + map[nx][ny]});
				}
			}
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}