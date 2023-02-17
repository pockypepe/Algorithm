import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ans = new int[N / 5 + 1];
		int result = Integer.MAX_VALUE;
		if (N % 3 == 0) {
			ans[0] = N / 3;
		}
		for (int i = 1; i < (N / 5 + 1); i++) {
			int temp = N - 5 * i;
			if (temp % 3 == 0) {
				ans[i] = i + (temp / 3);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == 0) continue;
			result = Math.min(ans[i], result);
		}
		if (result != Integer.MAX_VALUE) System.out.println(result);
		else System.out.println(-1);
	}
}
