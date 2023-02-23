import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] term, profit;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		term = new int[N];
		profit = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			term[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
			if (term[i] + i > N) {
				term[i] = 1;
				profit[i] = 0;
			}
		}
		subSet(0, 0);
		
		System.out.println(ans);
	}
	
	static void subSet(int cnt, int sum) {
		if (cnt >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		subSet(cnt + term[cnt], sum + profit[cnt]);
		subSet(cnt + 1, sum);
	}
}