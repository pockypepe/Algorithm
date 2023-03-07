import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Node[] adjList;
    static int[] inDegree;
    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            orderList.add(cur);

            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if (--inDegree[temp.vertex] == 0) q.offer(temp.vertex);
            }
        }

        return orderList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new Node[N + 1];
        inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }

        ArrayList<Integer> ans = topologySort();

        for (int a : ans) System.out.print(a + " ");
    }
}