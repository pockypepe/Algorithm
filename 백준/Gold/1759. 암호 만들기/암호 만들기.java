import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static String[] input, temp;
	static String moum = "aeiou";
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		input = new String[C]; // 입력 받은 문자
		temp = new String[L]; // 뽑을 문자
		sb = new StringBuilder();
		
		for(int i = 0; i < C; i++) input[i] = sc.next();
		
		Arrays.sort(input);
		
		comb(0, 0);
		System.out.println(sb.toString());
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == L) {
			int moCnt = 0;
			int jaCnt = 0;
			for (int i = 0; i < temp.length; i++) {
				if (moum.contains(temp[i])) moCnt++;
				else jaCnt++;
			}
			if (moCnt >= 1 && jaCnt >= 2) {
				for (int i = 0; i < temp.length; i++) sb.append(temp[i]);
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			temp[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}