import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static boolean[] visited;

    private static void moveSubin() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        visited = new boolean[200001];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            if (cur[0] == K) {
                ans = cur[1];
                break;
            }

            if (cur[0] < 0) continue;

            int[] move = {1, -1, cur[0]};
            for (int i = 0; i < 3; i++) {
                int next = cur[0] + move[i];
                if (isInRange(next) && !visited[next]) q.offer(new int[] {next, cur[1] + 1});
            }
        }
    }

    private static boolean isInRange(int next) {
        return 0 <= next && next < 200001;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        moveSubin();

        System.out.println(ans);
    }
}
