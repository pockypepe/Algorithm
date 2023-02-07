import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[][] farm = new String[n][n];
			
			for (int i = 0; i < n; i++) {
				farm[i] = br.readLine().split("");
			}
			
			int sum = 0;
			int idx = 0;
			
			while (n - idx > 0) {
				for (int i = idx; i < n - idx; i++) {
					sum += Integer.parseInt(farm[n / 2 - idx][i]);
				}
				idx += 1;
				for (int i = idx; i < n - idx; i++) {
					sum += Integer.parseInt(farm[n / 2 + idx][i]);
				}
				
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}