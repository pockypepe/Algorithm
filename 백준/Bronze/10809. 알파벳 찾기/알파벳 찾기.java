import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split("");
		int[] ans = new int[26];
		
		for (int i = 0; i < 26; i++) ans[i] = -1;
		
		for (int i = 0; i < input.length; i++) {
			int index = input[i].charAt(0) - 'a';
			if (ans[index] != -1) continue;
			ans[index] = i;
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}
}