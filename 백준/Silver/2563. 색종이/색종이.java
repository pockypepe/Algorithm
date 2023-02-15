import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		visited = new boolean[100][100];
		map = new int[101][101];
		int[][] input = new int[n][2];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				int count = 0;
				for (int k = 0; k < 10; k++) {
					if (map[input[i][0] + j][input[i][1] + k] == 1) continue;
					map[input[i][0] + j][input[i][1] + k] = 1;
					count++;
				}				
				ans += count;
			}
		}
		System.out.println(ans);
	}
}
