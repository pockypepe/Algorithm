import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;

    private static void getElement(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int i = 0; i < N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            map[from][to] = map[to][from] = 1;
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            getElement(i);
            count++;
        }

        System.out.println(count);
    }
}