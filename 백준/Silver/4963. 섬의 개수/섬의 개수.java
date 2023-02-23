import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if (W == 0 && H ==0) break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(new int[] {i, j});
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	private static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			
			
			for (int i = 0; i < 8; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (isInRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < H && 0 <= ny && ny < W;
	}
}