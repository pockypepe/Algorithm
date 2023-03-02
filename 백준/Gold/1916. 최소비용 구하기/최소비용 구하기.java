import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		List<int[]> [] graph = new List[V];
		for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new int[] {to, weight});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		distance[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			
			if (visited[current[0]]) continue;
			visited[current[0]] = true;
			
			for (int[] bus : graph[current[0]]) {
				if (distance[bus[0]] > current[1] + bus[1]) {
					distance[bus[0]] = current[1] + bus[1];
					pq.offer(new int[] {bus[0], distance[bus[0]]});
				}
			}
		}
		System.out.println(distance[end]);
	}
}