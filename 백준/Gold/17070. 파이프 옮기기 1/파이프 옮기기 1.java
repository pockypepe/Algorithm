import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] map;
    static int[][] dir = {
            {0, 2}, // 가로 -> 가로 대각선
            {1, 2}, // 세로 -> 세로 대각선
            {0, 1, 2} // 대각선 -> 가로 세로 대각선
    };
    static int[][] way = {
            {0, 1}, // 가로
            {1, 0}, // 세로
            {1, 1} // 대각선
    };

    private static void movePipe(int hx, int hy, int d) {
        // 마지막 위치에 온다면
        if (hx == N - 1 && hy == N - 1) {
            ans++;
            return;
        }

        // 대각선 검사
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int nx = hx + way[i][0];
            int ny = hy + way[i][1];
            if (!isInRange(nx, ny) || map[nx][ny] == 1) cnt++;
        }
        // 대각선 필요 조건이 된다면 대각선으로 이동
        if (cnt == 0) movePipe(hx + 1, hy + 1, 2);

        // 대각선 or 가로
        if (d == 2 || d == 0) {
            int nx = hx + way[0][0];
            int ny = hy + way[0][1];
            if (isInRange(nx, ny) && map[nx][ny] == 0) movePipe(nx, ny, 0);
        }

        // 대각선 or 세로
        if (d == 2 || d == 1) {
            int nx = hx + way[1][0];
            int ny = hy + way[1][1];
            if (isInRange(nx, ny) && map[nx][ny] == 0) movePipe(nx, ny, 1);
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        // 파이프와 현재 방향
        movePipe(0, 1, 0);

        System.out.println(ans);
    }
}
