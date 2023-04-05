import java.io.*;
import java.util.*;

public class Solution {
    static int N, B, ans;
    static int[] height;

    private static void subSet() {
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) continue;
                sum += height[j];
            }
            if (sum >= B) ans = Math.min(ans, sum);
        }
        ans -= B;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            height = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            subSet();

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}