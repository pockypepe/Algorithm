import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] numbers, inputs;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		inputs = new int[N];
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) inputs[i] = sc.nextInt();
		
		Arrays.sort(inputs);
		
		comb(0, 0);
		
		System.out.println(sb.toString());
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			for (int i : numbers) sb.append(i + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i);
		}
	}
}
