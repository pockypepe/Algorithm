import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited;

    private static void throwDice() {
        visited = new boolean[101];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == 100) {
                ans = cur[1];
                break;
            }

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for (int i = 1; i < 7; i++) {
                int next = cur[0] + i;
                if (next <= 100 && map.get(next) <= 100 && !visited[next]) {
                    q.offer(new int[] {map.get(next), cur[1] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 101; i++) map.put(i, i);

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, to);
        }

        throwDice();

        System.out.println(ans);
    }
}