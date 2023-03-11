import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>();
        int setSize = set.size();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            set.add(name);
            if (setSize == set.size()) {
                pq.offer(name);
                continue;
            }
            setSize += 1;
        }

        sb.append(pq.size()).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
