import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static List<Integer>[] list;

    private static int findKevinBacon(int start, int find) {
        visited = new boolean[N + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {start, 1});
        int kevin = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == find) {
                kevin = cur[1];
                break;
            }

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for (int i : list[cur[0]]) {
                if (!visited[i]) q.offer(new int[] {i, cur[1] + 1});
            }
        }

        return kevin;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
           if (o1[0] == o2[0]) return o1[1] - o2[1];
           return o1[0] - o2[0];
        });
        for (int i = 1; i <= N; i++) {
            int kevinBacon = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                kevinBacon += findKevinBacon(i, j);
            }
            pq.offer(new int[] {kevinBacon, i});
        }

        System.out.println(pq.poll()[1]);
    }
}