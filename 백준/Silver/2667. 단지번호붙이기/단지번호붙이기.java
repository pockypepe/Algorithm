import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] map;

    private static int countDanji(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (isInRange(nx, ny) && map[nx][ny] == '1' && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return cnt;
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        List<Integer> danji = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    danji.add(countDanji(i, j));
                }
            }
        }
        Collections.sort(danji);
        System.out.println(danji.size());
        for (int i : danji) System.out.println(i);
    }
}