import java.io.*;
import java.util.*;

/*
    1. 바이러스 위치를 조합으로 만들기
    2. 조합된 바이러스 위치에서 bfs
 */
public class Main {
    static int N, M, wall, ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Virus[] temp;
    static int[][] map;
    static boolean[][] visited;
    static List<Virus> virus;
    static List<Virus[]> combination;

    static class Virus {
        int x, y;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void combVirus(int cnt, int start) {
        if (cnt == M) {
            Virus[] copy = temp.clone();
            combination.add(copy);
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            temp[cnt] = virus.get(i);
            combVirus(cnt + 1, i + 1);
        }
    }

    private static void spreadVirus(Virus[] virus) {
        visited = new boolean[N][N];

        Queue<int[]> q = new ArrayDeque<>();
        // 맵에 현재 바이러스 위치 큐에 삽입
        for (Virus v : virus) {
            q.offer(new int[] {v.x, v.y, 0});
            visited[v.x][v.y] = true;
        }

        int time = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            time = Math.max(time, cur[2]);
            if (time == ans) break;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) cnt++;
            }
        }

        if (wall + cnt == N * N) ans = Math.min(ans, time);
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        wall = 0;
        map = new int[N][N];
        temp = new Virus[M];
        virus = new ArrayList<>();
        combination = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 1) wall++;
                if (temp == 2) virus.add(new Virus(i, j));
            }
        }

        combVirus(0, 0);

        for (Virus[] v : combination) spreadVirus(v);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}