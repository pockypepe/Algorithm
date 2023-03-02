import java.io.*;
import java.util.*;

public class Main {
	static List<int[]> [] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		int[] distance = new int[V];
		list = new ArrayList[V];
		for (int i = 0; i < V;i++) list[i] = new ArrayList<>();
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, weight});
		}
		
		distance[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			
			if (visited[current[0]]) continue;
			visited[current[0]] = true;
			
			for (int[] i : list[current[0]]) {
				if (distance[i[0]] > i[1] + current[1]) {
					distance[i[0]] = i[1] + current[1];
					pq.offer(new int[] {i[0], distance[i[0]]});
				}
			}
		}
		
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
