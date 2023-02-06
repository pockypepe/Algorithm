import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apt = new int[k + 1][n];
			for (int i = 0; i < n; i++) {
				apt[0][i] = i + 1;
			}
			for (int i = 1; i < k + 1; i++) {
				for (int j = 0; j < n; j++) {
					if (j == 0) {
						apt[i][j] = 1;
					} else {
						apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
					}
				}
			}
			System.out.println(apt[k][n - 1]);
		}
	}
}