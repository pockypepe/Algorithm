import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 1; i < n; i++) {
			int sum = i;
			int idx = i;
			while(idx != 0) {
				sum += idx % 10;
				idx = idx / 10;
			}
			if (sum == n) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}