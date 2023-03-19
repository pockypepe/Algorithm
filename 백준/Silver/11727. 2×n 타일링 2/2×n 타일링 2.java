import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < 1001; i++) {
            if (i % 2 == 0) dp[i] = (dp[i - 1] * 2 + 1) % 10007;
            else dp[i] = (dp[i - 1] * 2 - 1) % 10007;
        }

        System.out.println(dp[n]);
    }
}