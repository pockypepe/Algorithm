import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<int[]>[] adjList, reverse;

    private static int[] goGo(int start, List<int[]>[] adj) {
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cur = current[0];

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int[] next : adj[cur]) {
                if (!visited[next[0]] && distance[next[0]] > distance[cur] + next[1]) {
                    distance[next[0]] = distance[cur] + next[1];
                    pq.offer(new int[] {next[0], distance[next[0]]});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        adjList = new List[N];
        for (int i = 0; i < N; i++) adjList[i] = new ArrayList();

        reverse = new List[N];
        for (int i = 0; i < N; i++) reverse[i] = new ArrayList();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int price = Integer.parseInt(st.nextToken());
            adjList[start].add(new int[] {end, price});
            reverse[end].add(new int[] {start, price});
        }

        int[] goParty = goGo(X, adjList);
        int[] goHome = goGo(X, reverse);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (i == X) continue;
            ans = Math.max(ans, goParty[i] + goHome[i]);
        }
        System.out.println(ans);
    }
}