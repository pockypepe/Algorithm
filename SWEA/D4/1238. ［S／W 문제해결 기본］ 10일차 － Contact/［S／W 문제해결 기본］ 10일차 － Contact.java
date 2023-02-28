import java.io.*;
import java.util.*;

public class Solution {
	static int count;
	static int[][] map;
	static boolean[] visited;
	static List<int[]> contact;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()); // 시작점
			
			map = new int[101][101];
			visited = new boolean[101]; // 방문 체크
			contact = new ArrayList<int[]>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				// from, to 지정 연결되어있으면 1, 아니면 0으로 설정
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			bfs(start, 0);
			int max = 0;
			for (int[] i : contact) {
				if (i[1] == count) {
					max = Math.max(max, i[0]);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		
	}

	private static void bfs(int start, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {start, cnt});
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			if (visited[current[0]]) continue;
			visited[current[0]] = true;
			current[1]++;
			
			for (int i = 0; i < 101; i++) {
				if (!visited[i] && map[current[0]][i] != 0) {
					q.offer(new int[] {i, current[1]});
					contact.add(new int[] {i, current[1]});
				}
			}
			count = current[1] - 1;
		}
		
	}
}
