import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] map = new long[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(map[i], Integer.MAX_VALUE / 2 - 1);

        for (int i = 0; i < m ;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            map[start][end] = Math.min(map[start][end],Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                   if (i == k || j == k) continue;
                   map[j][k] = Math.min(map[j][i] + map[i][k], map[j][k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == Integer.MAX_VALUE / 2 - 1) sb.append(0 + " ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
