import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] p;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			
			makeSet(); // 집합 만들기
						
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (mode == 0) {
					union(a, b); // 집합 합치기
				} else {
					check(a, b); // 서로 체크해서 맞으면 1, 틀리면 0
				}
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	private static void check(int a, int b) {
		// a집합의 대표와 b집합의 대표가 서로 같으면 1, 다르면 0
		if (find(a) == find(b)) sb.append(1);
		else sb.append(0);
	}

	private static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return;
		
		p[bRoot] = aRoot;
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) p[i] = i;
	}
}
