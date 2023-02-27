import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N + 1];
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) if(p[i] == i) cnt++;
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return;
		
		p[bRoot] = aRoot;
	}

	private static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) p[i] = i;
	}
}
