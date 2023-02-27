import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			
			char start = input.charAt(0);
			int cnt = 0;
			if (start == '1') cnt = 1;
			
			for (int i = 1; i < input.length(); i++) {
				if (input.charAt(i) == start) continue;
				start = input.charAt(i);
				cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}