import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L, max;
	static int[] score, cal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 칼로리 합
			
			score = new int[N];
			cal = new int[N];
            max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			subSet();
			System.out.println("#" + t + " " + max);
		}
	}

	private static void subSet() {
		for (int i = 1; i < (1 << N); i++) {
			int scoreSum = 0; // 원소의 합
			int calSum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				scoreSum += score[j];
				calSum += cal[j];
			}
			if (calSum <= L) max = Math.max(max, scoreSum);
		}
	}
}