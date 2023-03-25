import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] ans;
    static int[][] map;

    private static void checkSection(int x, int y, int range) {
        int zeroCnt = 0, oneCnt = 0, moCnt = 0;
        for (int i = x; i < range + x; i++) {
            for (int j = y; j < range + y; j++) {
                if (map[i][j] == 0) zeroCnt++;
                else if (map[i][j] == 1) oneCnt++;
                else moCnt++;
            }
        }

        if (moCnt == range * range) ans[0]++;
        else if (zeroCnt == range * range) ans[1]++;
        else if (oneCnt == range * range) ans[2]++;
        else {
            checkSection(x, y, range / 3);
            checkSection(x, y + range / 3, range / 3);
            checkSection(x, y + range / 3 * 2, range / 3);

            checkSection(x + range / 3, y, range / 3);
            checkSection(x + range / 3, y + range / 3, range / 3);
            checkSection(x + range / 3, y + range / 3 * 2, range / 3);

            checkSection(x + range / 3 * 2, y, range / 3);
            checkSection(x + range / 3 * 2, y + range / 3, range / 3);
            checkSection(x + range / 3 * 2, y + range / 3 * 2, range / 3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = new int[3];
        int zeroCnt = 0, oneCnt = 0, moCnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = status;
                if (status == 0) zeroCnt++;
                else if (status == 1) oneCnt++;
                else moCnt++;
            }
        }

        checkSection(0, 0, N);

        for (int i : ans) System.out.println(i);
    }
}