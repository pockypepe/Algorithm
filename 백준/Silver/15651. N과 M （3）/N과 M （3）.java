import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] numbers, inputs;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		numbers = new int[M];
		
		for (int i = 0; i < N; i++) inputs[i] = i + 1;
		perm(0);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
		}
	}
}