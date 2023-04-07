import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] input, fenwick;
    static StringBuilder sb;

    private static void doFenwick(int idx, long num) {
        while (idx <= N) {
            fenwick[idx] += num;
            idx += idx & -idx;
        }
    }

    private static void printFenwick(int start, int end) {
        sb.append(sum(end) - sum(start - 1) + "\n");
    }

    private static long sum(int num) {
        long sum = 0;
        while (num > 0) {
            sum += fenwick[num];
            num -= num & -num;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new long[N + 1];
        fenwick = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            input[i] = Long.parseLong(br.readLine());
            doFenwick(i, input[i]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            long num = Long.parseLong(st.nextToken());
            if (mode == 1) {
                doFenwick(idx, num - input[idx]);
                input[idx] = num;
            }
            else if (mode == 2) printFenwick(idx, (int) num);
        }
        System.out.println(sb.toString());
    }
}
