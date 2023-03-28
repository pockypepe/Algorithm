import java.io.*;
import java.util.*;

public class Main {
    static int oneCnt = 0, zeroCnt = 0;
    static int[][] map;

    private static void makeSecetion(int x, int y, int range) {
        int sum = 0;
        for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                sum += map[i][j];
            }
        }

        if (sum == 0) zeroCnt++;
        else if (sum == range * range) oneCnt++;
        else {
            int newRange = range / 2;
            makeSecetion(x, y, newRange);
            makeSecetion(x, y + newRange, newRange);
            makeSecetion(x + newRange, y, newRange);
            makeSecetion(x + newRange, y + newRange, newRange);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSecetion(0, 0, N);

        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }
}