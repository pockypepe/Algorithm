import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static TreeSet<Integer> [] list;
    static StringBuilder sb;

    private static void dfs(int start) {
        for (int i : list[start]) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(i + " ");
            dfs(i);
        }
    }

    private static void bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur + " ");

            for (int i : list[cur]) {
                if (!visited[i]) q.offer(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        list = new TreeSet[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        visited[V] = true;
        sb.append(V + " ");
        dfs(V);
        sb.append("\n");
        bfs(V);

        System.out.println(sb.toString());
    }
}