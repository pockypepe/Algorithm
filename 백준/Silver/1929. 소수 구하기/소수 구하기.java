import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] arr = new boolean[N + 1];
		
		// 0과 1을 제외한 모든 수가 소수라고 가정
		for (int i = 2; i < N + 1; i++) arr[i] = true;
		
		for (int i = 2; i < Math.sqrt(N) + 1; i++) {
			if (arr[i] == true) { // 소수라면 소수의 배수를 모두 false로 전환
				int j = 2;
				while (i * j <= N) {
					arr[i * j] = false;
					j++;
				}
			}
		}
		
		for (int i = M; i < N + 1; i++) {
			if (arr[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}