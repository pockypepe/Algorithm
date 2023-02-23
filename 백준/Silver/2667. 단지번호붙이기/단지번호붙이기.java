import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer> danjis;
	static String[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		danjis = new ArrayList<>();
		
		for (int i = 0; i < N; i++) map[i] = br.readLine().split("");
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("1") && !visited[i][j]) {
					cnt++;
					bfs(new int[] {i, j});
				}
			}
		}
		
		Collections.sort(danjis);
		
		System.out.println(cnt);
		for (int i : danjis) {
			if(i == 0) {
				System.out.println(i + 1);
				continue;
			}
			System.out.println(i);
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	private static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		
		int danji = 0;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (visited[temp[0]][temp[1]]) continue;
            visited[temp[0]][temp[1]] = true;
            danji++;
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (isInRange(nx, ny) && map[nx][ny].equals("1") && !visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
				}
			}
		}
		danjis.add(danji);
	}

	private static boolean isInRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}