import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edgeList);
			
			makeSet();
			
			long ans = 0;
			long count = 0;
			
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) {
					ans += e.weight;
					if (++count == V - 1) break;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static boolean union(int from, int to) {
		int fromRoot = find(from);
		int toRoot = find(to);
		if (fromRoot == toRoot) return false;
		parents[toRoot] = fromRoot;
		return true;
	}

	private static int find(int to) {
		if (parents[to] == to) return to;
		return parents[to] = find(parents[to]);
	}

	private static void makeSet() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) parents[i] = i;
	}
}