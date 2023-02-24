import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, normal, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		// dfs 호출될때마다 normal 증가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map[i][j]);
					normal++;
				}
			}
		}
		// R을 G로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		// visited 초기화
		visited = new boolean[N][N];
		// map에 B와 G로 구성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map[i][j]);
					cnt++;
				}
			}
		}
		
		System.out.println(normal + " " + cnt);
	}

	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isInRange(nx, ny) && map[nx][ny] == color && !visited[nx][ny]) {
				dfs(nx, ny, color);
			}
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}