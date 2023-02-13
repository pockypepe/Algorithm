import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[] price = new int[4];
			int[] month = new int[13];
			int[] min = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// one day, one month, three months, one year
			for (int i = 0; i < 4; i++) price[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// 이용일
			for (int i = 1; i < 13; i++) month[i] = Integer.parseInt(st.nextToken());
			
			// 1일권 한달권 최적화
			for (int i = 1; i < 13; i++) min[i] = Math.min(price[0] * month[i], price[1]);
			
			int[] dp = new int[15];
			
			for (int i = 3; i < 13; i++) {
				dp[1] = min[1];
				dp[2] = min[1] + min[2];
				// 3달 연속 한달치, 3달치 요금 비교
				dp[i] = Math.min(dp[i - 1] + min[i], dp[i - 3] + price[2]);
			}
			// 10월, 11월 이후 3달치 요금과 비교
			dp[12] = Math.min(dp[10] + price[2], dp[12]);
			dp[12] = Math.min(dp[11] + price[2], dp[12]);
			
			
			
			System.out.println("#" + t + " " + Math.min(dp[12], price[3]));
		}
	}
}