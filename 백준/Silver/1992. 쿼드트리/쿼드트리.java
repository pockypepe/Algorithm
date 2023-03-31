import java.io.*;

public class Main {
    static int[][] map;
    static StringBuilder sb;

    private static void makeSection(int x, int y, int n) {
        if (n == 1) {
            sb.append(map[x][y]);
            return;
        }

        int sum = 0;
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                sum += map[i][j];
            }
        }

        if (sum == 0) sb.append(0);
        else if (sum == n * n) sb.append(1);
        else {
            int newRange = n / 2;
            sb.append("(");
            makeSection(x, y, newRange);
            makeSection(x, y + newRange, newRange);
            makeSection(x + newRange, y, newRange);
            makeSection(x + newRange, y + newRange, newRange);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i ++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) map[i][j] = input[j] - '0';
        }

        makeSection(0, 0, N);

        System.out.println(sb.toString());
    }
}