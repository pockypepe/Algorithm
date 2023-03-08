import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static boolean[] visited;

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    ans++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }

        bfs();

        System.out.println(ans);
    }

}
