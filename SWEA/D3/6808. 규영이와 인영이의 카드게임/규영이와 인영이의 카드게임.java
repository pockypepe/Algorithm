import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int W, L;
	static int[] inyoungPerm;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			W = 0;
			L = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] kyuCard = new int[9]; // 규영이 고정
			int[] inCard = new int[9]; // 인영이 
			boolean[] total = new boolean[19];
			inyoungPerm = new int[9]; // 인영이 순열
			visited = new boolean[9];
			
			// 규영이 입력
			for (int i = 0; i < kyuCard.length; i++) {
				kyuCard[i] = Integer.parseInt(st.nextToken());
				total[kyuCard[i]] = true;
			}
			
			// 인영이 입력
			int cnt = 0;
			for (int i = 1; i < total.length; i++) {
				if (total[i]) continue;
				inCard[cnt++] = i;
			}
			perm(kyuCard, inCard, 0);
			System.out.println("#" + t + " " + W + " " + L);
		}
	}
	
	// 승부
	private static void contest(int[] kyuCard, int[] inCard) {
		int kyuScore = 0;
		int inScore = 0;
		for (int i = 0; i < 9; i++) {
			if (kyuCard[i] > inCard[i]) kyuScore += kyuCard[i] + inCard[i];
			else inScore += kyuCard[i] + inCard[i];
			if (kyuScore >= 86 || inScore >= 86) break;
		}
		if (kyuScore > inScore) W++;
		else L++;
	}
	
	// 인영이 순열 돌리기
	private static void perm(int[] kyuCard, int[] inCard, int cnt) {
		if (cnt == inCard.length) {
			contest(kyuCard, inyoungPerm);
			return;
		}
		for (int i = 0; i < inCard.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			inyoungPerm[cnt] = inCard[i];
			perm(kyuCard, inCard, cnt + 1);
			visited[i] = false;
		}
	}
}