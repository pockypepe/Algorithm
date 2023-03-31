import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, c, h;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    private static void meltCheese(int hour) {
        visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny]
                        && map[cur[0]][cur[1]] == 0 && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    cnt++;
                    visited[nx][ny] = true;
                } else if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }

        if (sum == 0) {
            h = hour;
            c = cnt;
            return;
        }
        meltCheese(hour + 1);
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        meltCheese(1);

        System.out.println(h);
        System.out.println(c);
    }
}