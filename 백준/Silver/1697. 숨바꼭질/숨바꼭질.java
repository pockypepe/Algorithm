import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, ans;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		ans = Integer.MAX_VALUE;
		visited = new boolean[200001];
		
		bfs(N);
		System.out.println(ans);
	}
	private static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			if (visited[current[0]]) continue;
			visited[current[0]] = true;

			if (current[0] == K) {
				ans = Math.min(ans, current[1]);
			}
			
			int[] dx = {-1, 1, current[0]};
			for (int i = 0; i < 3; i++) {
				int nx = current[0] + dx[i];
				if (isInRange(nx) && !visited[nx]) {
					q.offer(new int[] {nx, current[1] + 1});
				}
			}
		}
		
	}
	
	private static boolean isInRange(int nx) {
		return 0 <= nx && nx < 200001;
	}
}