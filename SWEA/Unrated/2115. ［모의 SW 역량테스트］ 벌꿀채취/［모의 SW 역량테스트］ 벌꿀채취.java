import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, C, ans;
    static int[][] map, profit;

    private static void makeProfit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                setMaxProfit(i, j, 0, 0, 0);
            }
        }
    }
    // 부분집합
    private static void setMaxProfit(int i, int j, int cnt, int honeySum, int money) {
        if (honeySum > C) return;

        if (cnt == M) {
            profit[i][j - M] = Math.max(profit[i][j - M], money);
            return;
        }
        // 선택 안함
        setMaxProfit(i, j + 1, cnt + 1, honeySum, money);
        // 선택함
        setMaxProfit(i, j + 1, cnt + 1, honeySum + map[i][j], money + map[i][j] * map[i][j]);
    }

    private static void setMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                // 같은 행일때
                for (int k = j + M; k <= N - M; k++) {
                    ans = Math.max(ans, profit[i][j] + profit[i][k]);
                }

                //다른 행일때
                for (int x = i + 1; x < N; x++) {
                    for (int y = 0; y <= N - M; y++) {
                        ans = Math.max(ans, profit[i][j] + profit[x][y]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            ans = Integer.MIN_VALUE;

            map = new int[N][N];
            profit = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            makeProfit();

            setMax();

            System.out.println("#" + tc + " " + ans);
        }
    }

}
