import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
    현재 상태, 끝 점과 주변의 벽의 유뮤
 */
public class Main {
    static int N, ans;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int[][] map;
    static Queue<int[]> q;

    private static void pipeMove() {
        q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[2] == N - 1 && cur[3] == N - 1) {
                ans++;
                continue;
            }

            checkCross(cur);
            if (cur[0] == cur[2]) { // 가로 상태
                checkWidth(cur);
            } else if (cur[1] == cur[3]) { // 세로 상태
                checkHeight(cur);
            } else { // 대각선 상태
                checkWidth(cur);
                checkHeight(cur);
            }
        }
    }

    private static void checkHeight(int[] cur) {
        if (isInRange(cur[2] + 1, cur[3]) && map[cur[2] + 1][cur[3]] != 1)
            q.offer(new int[]{cur[2], cur[3], cur[2] + 1, cur[3]});
    }

    private static void checkWidth(int[] cur) {
        if (isInRange(cur[2], cur[3] + 1) && map[cur[2]][cur[3] + 1] != 1)
            q.offer(new int[]{cur[2], cur[3], cur[2], cur[3] + 1});
    }

    private static void checkCross(int[] cur) {
        for (int i = 0; i < 3; i++) {
            int nx = cur[2] + dx[i];
            int ny = cur[3] + dy[i];
            if (isInRange(nx, ny) && map[nx][ny] != 1) continue;
            return;
        }
        q.offer(new int[]{cur[2], cur[3], cur[2] + 1, cur[3] + 1});
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        pipeMove();

        System.out.println(ans);
    }
}