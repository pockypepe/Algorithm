import java.io.*;
import java.util.*;

public class Main {
	static int R, C, M, ans;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
	static Shark[][] map;
	
	static class Shark {
		int r, c, speed, dir, size;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 map = new Shark[R + 1][C + 1];
		 
		 for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int r = Integer.parseInt(st.nextToken());
			 int c = Integer.parseInt(st.nextToken());
			 int speed = Integer.parseInt(st.nextToken());
			 int dir = Integer.parseInt(st.nextToken()) - 1;
			 int size = Integer.parseInt(st.nextToken());
			 map[r][c] = new Shark(r, c, speed, dir, size);
		 }
		 
		 for (int i = 1; i <= C; i++) fishing(i);
		 
		 System.out.println(ans);
	}

	private static void fishing(int start) {
		for (int i = 1; i <= R; i++) {
			if (map[i][start] == null) continue;
			ans += map[i][start].size;
			map[i][start] = null;
			break;
		}
		moveShark();
	}
	
	static int[] way = new int[] {1, 0, 3, 2};
	
	private static void moveShark() {
		List<Shark> list = new ArrayList<>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				// 상어만 리스트에 담고
				if (map[i][j] != null) {
					list.add(map[i][j]);
					map[i][j] = null; // 맵에 있는 상어 모두 지우기
				}
			}
		}
		// 상어 위치 바꾸기
		for (Shark s : list) {
			int nr = s.r;
			int nc = s.c;
			for (int i = 0; i < s.speed; i++) {
				nr += dx[s.dir];
				nc += dy[s.dir];
				if (!isInRange(nr, nc)) { // 범위 벗어나면 방향바꾸기
					nr -= dx[s.dir];
					nc -= dy[s.dir];
					s.dir = way[s.dir];
					nr += dx[s.dir];
					nc += dy[s.dir];
				}
				s.r = nr;
				s.c = nc;
			}
		}
		// 상어 위치 비교하고 map에 저장
		for (Shark s : list) {
			if (map[s.r][s.c] == null) map[s.r][s.c] = s;
			else {
				if (s.size > map[s.r][s.c].size) map[s.r][s.c] = s;
			}
		}
	}

	private static boolean isInRange(int nr, int nc) {
		return 1 <= nr && nr <= R && 1 <= nc && nc <= C;
	}
}