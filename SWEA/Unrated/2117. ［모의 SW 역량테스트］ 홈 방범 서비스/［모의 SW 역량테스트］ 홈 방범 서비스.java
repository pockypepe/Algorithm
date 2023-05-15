import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, ans;
    static int[][] map;
    static List<Home> homeList;
    static class Home {
        int x, y;

        Home (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void aroundHome(int x, int y) {
        for (int k = 1; k <= 21; k++) {
            int count = 0;
            int price = k * k + (k-1) * (k-1);

            for (Home home : homeList) {
                int distance = Math.abs(home.x - x) + Math.abs(home.y - y);
                if (distance < k) count++;
            }

            int profit = count * M - price;
            if (profit < 0) continue;
            ans = Math.max(ans, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            homeList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    if (temp == 1) homeList.add(new Home(i, j));
                }
            }

            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) aroundHome(i, j);
            }

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
