import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(st.nextToken()));

        int ans = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sum += cur;
            ans += sum;
        }

        System.out.println(ans);
    }
}