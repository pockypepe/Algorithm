import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current + " ");
			
			for (int i = 1; i <= N; i++) {
				if (map[current][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		visited[start] = true;
		while (!stack.isEmpty()) {
			int current = stack.pop();
			sb.append(current + " ");
			
			for (int i = 1; i <= N ; i++) {
				if (map[current][i] == 1 && !visited[i]) {
					dfs(i);
				}
			}
		}
	}

}
