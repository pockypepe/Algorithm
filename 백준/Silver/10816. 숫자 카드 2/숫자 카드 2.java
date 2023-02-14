import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] plus = new int[10000001];
		int[] minus = new int[10000001];
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (idx >= 0) plus[idx]++;
			else minus[Math.abs(idx)]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (idx >= 0) sb.append(plus[idx]).append(" ");
			else sb.append(minus[Math.abs(idx)]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}