import java.io.*;
import java.util.*;

public class Solution {
    static int D, W, K, ans;
    static int[][] map;

    private static void putChemi(int row, int cnt, int[][] map) {
        if (row == D) {
            if (checkFilm(map)) {
                ans = Math.min(ans, cnt);
            }
            return;
        }

        if (cnt >= ans) return;

        int[][] copy = copyMap(map);

        putChemi(row + 1, cnt, copy);
        putChemi(row + 1, cnt + 1, fill(copy, 1, row));
        putChemi(row + 1, cnt + 1, fill(copy, 0, row));
    }

    private static int[][] fill(int[][] copy, int num, int row) {
        for (int i = 0; i < W; i++) copy[row][i] = num;
        return copy;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copy = new int[D][W];
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    private static boolean checkFilm(int[][] map) {
        int result = 0;
        for (int i = 0; i < W; i++) {
            int cnt = 1;
            for (int j = 1; j < D; j++) {
                if (map[j][i] == map[j - 1][i]) cnt++;
                else cnt = 1;
                if (cnt >= K) {
                    result++;
                    break;
                }
            }
            if (result != i + 1) break;
        }
        return result == W ? true : false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;
            map = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            putChemi(0, 0, map);

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}