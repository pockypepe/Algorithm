import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, ans;
	static int[][] customer, permutation;
	static int[] company, home;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			customer = new int[N + 2][];
			permutation = new int[N + 2][2];
			permutation[0] = company;
			permutation[N + 1] = home;
			
			for (int i = 0; i < N; i++) customer[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			ans = Integer.MAX_VALUE;
			visited = new boolean[N];
			
			perm(0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			int distance = 0;
			for (int i = 0; i < N + 1; i++) {
				distance += Math.abs(permutation[i][0] - permutation[i + 1][0]) + Math.abs(permutation[i][1] - permutation[i + 1][1]);
			}
			ans = Math.min(ans, distance);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			permutation[cnt + 1] = customer[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}