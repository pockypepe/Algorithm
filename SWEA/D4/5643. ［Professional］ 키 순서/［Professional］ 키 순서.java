import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                map[a][b] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    for (int k = 0; k < N; k++) {
                        if (i == k || k == j) continue;
                        if (map[j][i] == 1 && map[i][k] == 1) map[j][k] =1;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    cnt += map[i][j] + map[j][i];
                }
                if (cnt == N - 1) ans++;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}