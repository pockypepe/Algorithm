import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, ans, gx, gy;
    static int[] visited;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int[][] map;

    private static void moveCafe(int x, int y, int cnt, int dir) {
        visited[map[x][y]] = 1;

        int nx, ny;
        for (int d = dir; d < 4; d++) {
            nx = x + dx[dir];
            ny = y + dy[dir];

            if (nx == gx && ny == gy && cnt >= 4) {
                ans = Math.max(ans, cnt);
                break;
            }

            if (isInRange(nx, ny) && visited[map[nx][ny]] != 1) moveCafe(nx, ny, cnt + 1, d);

        }

        visited[map[x][y]] = 0;
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new int[101];
            ans = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    gx = i;
                    gy = j;
                    moveCafe(i, j, 1, 0);
                }
            }

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}