import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] w = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(w);
			int p1 = 0;
			int p2 = N - 1;
			int max = -1;
			while (p1 < p2) {
				int sum = w[p2] + w[p1];
				
				if (w[p2] + w[p1] <= M) {
					max = Math.max(max, sum); 
					p1++;
				}
				else p2--;
			}
			System.out.println("#" + t + " " + max);
		}
	}
}