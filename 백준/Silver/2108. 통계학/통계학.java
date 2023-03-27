import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);
            System.out.println(num);
            System.out.println(num);
            System.out.println(0);
            return;
        }

        int[] num = new int[8001]; // 4000이 0 역할
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0, max = 0, mid = 0, min = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            num[4000 + temp]++;
            pq.offer(temp);
        }
        int idx = 1;
        while (!pq.isEmpty()) {
            if (idx == 1) min = pq.poll();
            else if (idx == (N + 1) / 2) mid = pq.poll();
            else max = pq.poll();
            idx++;
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o2[1] == o1[1]) return o1[0] - o2[0];
                    else return o2[1] - o1[1];
                }
        );
        for (int i = 0; i < 8001; i++) {
            if (num[i] != 0) pq2.offer(new int[]{i, num[i]});
        }
        int[] cur = pq2.poll();
        int[] next = pq2.poll();
        int most = cur[1] == next[1] ? next[0] : cur[0];
        System.out.println(Math.round(1.0 * sum / N));
        System.out.println(mid);
        System.out.println(most - 4000);
        System.out.println(max - min);
    }
}