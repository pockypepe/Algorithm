import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 1000 - sc.nextInt();
		int cnt = 0;
		
		int[] change = new int[] {500, 100, 50, 10, 5, 1};
		int[] ans = new int[6];
		
		for (int i = 0; i < 6; i++) {
			ans[i] = N / change[i];
			N = N % change[i];
		}
		
		for (int i = 0; i < 6; i++) cnt += ans[i];
		
		System.out.println(cnt);
	}
}