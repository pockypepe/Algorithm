import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] numbers, inputs;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		inputs = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) inputs[i] = sc.nextInt();
		Arrays.sort(inputs);
		perm(0, 0);
	}

	private static void perm(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt + 1, i + 1);
		}
	}
}
