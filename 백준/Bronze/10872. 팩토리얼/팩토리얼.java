import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(factorial(num));
	}

	private static int factorial(int num) {
		if (num == 0 || num == 1) return 1;
		
		return num * factorial(num - 1);
	}
}
