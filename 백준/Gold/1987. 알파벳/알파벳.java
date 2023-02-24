import java.io.*;
import java.util.*;

public class Main {
	static int R, C, ans, cnt;
	static char[][] map;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new int[26]; // 방문 체크 배열
		map = new char[R][];
		
		for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		
		dfs(new int[] {0, 0, 1});
		
		System.out.println(ans);
	}
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	private static void dfs(int[] start) {

		int idx = map[start[0]][start[1]] - 'A';

		visited[idx] = 1;
		ans = Math.max(ans, start[2]);
		
		for (int d = 0; d < 4; d++) {
			int nx = start[0] + dx[d];
			int ny = start[1] + dy[d];
			if (isInRange(nx, ny) && visited[map[nx][ny] - 'A'] != 1) {
				dfs(new int[] {nx, ny, start[2] + 1});
			}
		}
		visited[idx] = 0;
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < R && 0 <= ny && ny < C;
	}
}