import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            if (cnt == 2) {
                cnt = 0;
                pq.poll();
                continue;
            }
            sum += pq.poll();
            cnt++;
        }

        System.out.println(sum);
    }
}