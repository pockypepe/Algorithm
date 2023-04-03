import java.io.*;
import java.util.*;

public class Solution {
    static int N, ans;
    static int[] end;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb;

    private static void swimSamsung(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) return o1[3] - o2[3];
            return o1[2] - o2[2];
        });
        boolean check = false;
        int cnt = 0;
        q.offer(new int[] {x, y, 0, cnt++});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                check = true;
                ans = Math.min(ans, cur[2]);
                break;
            }

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (isInRange(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) q.offer(new int[] {nx, ny, cur[2] + 1, cnt++});
                    if (map[nx][ny] == 2 && cur[2] % 3 == 0) q.offer(new int[] {nx, ny, cur[2] + 3, cnt++});
                    if (map[nx][ny] == 2 && cur[2] % 3 == 1) q.offer(new int[] {nx, ny, cur[2] + 2, cnt++});
                    if (map[nx][ny] == 2 && cur[2] % 3 == 2) q.offer(new int[] {nx, ny, cur[2] + 1, cnt++});
                }
            }
        }
        if (!check) ans = -1;
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            swimSamsung(x, y);

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
