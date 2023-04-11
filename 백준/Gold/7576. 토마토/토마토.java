import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static List<Tomato> tomato;

    static class Tomato {
        int x, y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void mature() {
        Queue<int[]> q = new ArrayDeque<>();
        for (Tomato t : tomato) q.offer(new int[] {t.x, t.y, 0});

        int time = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            time = Math.max(time, cur[2]);

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isInRange(nx, ny)  && map[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny, cur[2] + 1});
                    map[nx][ny] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }

        if (cnt == 0) ans = time;
        else ans = -1;
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < M && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        tomato = new ArrayList<>();

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 1) tomato.add(new Tomato(i, j));
            }
        }

        mature();

        System.out.println(ans);
    }
}
