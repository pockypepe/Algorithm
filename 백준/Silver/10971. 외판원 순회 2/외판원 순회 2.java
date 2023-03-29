import java.io.*;
import java.util.*;

public class Main {
    static int N, origin;
    static long ans;
    static int[][] map;

    private static void circuit(int start, boolean[] visited, int cnt, long sum) {
        if (sum > ans) return;
        if (cnt == N) {
            if (map[start][origin] == 0) return;
            ans = Math.min(ans, sum + map[start][origin]);
            return;
        }
        if (visited[start]) return;
        visited[start] = true;

        for (int i = 0; i < N; i++) {
            if (i != start && !visited[i] && map[start][i] != 0) {
                circuit(i, visited, cnt + 1, sum + map[start][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        map = new int[N][N];

        for (int i= 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            origin = i;
            circuit(i, new boolean[N], 1, 0);
        }

        System.out.println(ans);
    }
}