import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;

    private static void searchPath() {
        visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                ans = cur[2];
                return;
            }

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == '1')
                    q.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        searchPath();

        System.out.println(ans);
    }
}