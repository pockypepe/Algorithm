import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int start = 0;
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if (coin[i] <= K) start = i;
        }

        int ans = 0;
        for (int i = start; i >= 0; i--) {
            int count = K / coin[i];
            ans += count;
            K -= count * coin[i];
            if (K == 0) break;
        }

        System.out.println(ans);
    }
}