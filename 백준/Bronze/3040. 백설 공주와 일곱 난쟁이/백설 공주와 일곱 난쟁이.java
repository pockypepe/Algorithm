import java.util.Scanner;

public class Main {
	static int N = 9, R = 7;
	static int[] numbers, inputs;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numbers = new int[R];
		inputs = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) inputs[i] = sc.nextInt();
		
		nanjangs(0, 0);
	}

	private static void nanjangs(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for(int i : numbers) {
				sum += i;
			}
			if (sum == 100) {
				for (int i : numbers) {
					System.out.println(i);
				}
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			nanjangs(cnt + 1, i + 1);		
		}
	}
}