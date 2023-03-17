import java.io.*;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] =  2;
        for (int i = 6; i < dp.length; i++) dp[i] = dp[i - 1] + dp[i - 5];

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb.toString());
    }
}