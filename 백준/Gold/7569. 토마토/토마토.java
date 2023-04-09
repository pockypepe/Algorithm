import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H, zeroCnt, ans;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] map;
    static boolean[][][] visited;
    static List<int[]> list;

    private static void changeTomato() {
        visited = new boolean[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] tomato : list) q.offer(tomato);

        int time = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[2]][cur[0]][cur[1]]) continue;
            visited[cur[2]][cur[0]][cur[1]] = true;
            time = Math.max(time, cur[3]);
            if (map[cur[2]][cur[0]][cur[1]] == 0) zeroCnt--;

            if (zeroCnt == 0) {
                ans = time;
                break;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                int nz = cur[2] + dz[d];

                if (isInRange(nx, ny, nz) && !visited[nz][nx][ny] && map[nz][nx][ny] == 0) {
                    q.offer(new int[] {nx, ny, nz, cur[3] + 1});
                }
            }
        }

        if (zeroCnt != 0) ans = -1;
    }

    private static boolean isInRange(int nx, int ny, int nz) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j][k] = temp;
                    if (temp == 1) list.add(new int[] {j, k, i, 0}); // x, y, z, time
                    if (temp == 0) zeroCnt++;
                }
            }
        }

        changeTomato();

        System.out.println(ans);
    }
}