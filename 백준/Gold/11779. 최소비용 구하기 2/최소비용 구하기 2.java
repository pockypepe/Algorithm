import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans, count;
    static int[] distance;
    static boolean[] visited;
    static List<int[]>[] bus;
    static StringBuilder sb;
    static class Bus implements Comparable<Bus> {
        int to, weight, cnt;
        String root;

        public Bus(int to, int weight, int cnt, String root) {
            this.to = to;
            this.weight = weight;
            this.cnt = cnt;
            this.root = root;
        }

        @Override
        public int compareTo(Bus o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        bus = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) bus[i] = new ArrayList<>();
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            bus[from].add(new int[] {to, weight});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start, int end) {
        distance[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0, 1, start + " "));

        while (!pq.isEmpty()){
            Bus current = pq.poll();

            if (visited[current.to]) continue;
            visited[current.to] = true;

            if (current.to == end) {
                sb.append(current.weight).append("\n");
                sb.append(current.cnt).append("\n");
                sb.append(current.root);
                break;
            }

            for (int[] i : bus[current.to]) {
                if (!visited[i[0]] && distance[i[0]] > current.weight + i[1]) {
                    distance[i[0]] = current.weight + i[1];
                    pq.offer(new Bus(i[0], distance[i[0]], current.cnt + 1, current.root + i[0] + " "));
                }
            }
        }
    }
}