import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            set.add(input[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int s : set) pq.offer(s);

        int count = pq.size();
        for (int i = 0; i < count; i++) map.put(pq.poll(), pq.size());

        for (int i = 0; i < N; i++) sb.append(map.get(input[i]) + " ");

        System.out.println(sb.toString());
    }
}