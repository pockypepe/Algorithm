import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		
		bfs(0, 0, 1);
		
		System.out.println(ans);
	}

	private static void bfs(int x, int y, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, cnt});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			if (temp[0] == N - 1 && temp[1] == M - 1) {
				ans = temp[2];
				break;
			}
			if (visited[temp[0]][temp[1]]) continue;
			visited[temp[0]][temp[1]] = true;
			
			for(int d = 0; d < 4; d++) {
				int nx = temp[0] + dx[d];
				int ny = temp[1] + dy[d];
				if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == '1') {
					q.offer(new int[] {nx, ny, temp[2] + 1});
				}
			}
		}
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
}