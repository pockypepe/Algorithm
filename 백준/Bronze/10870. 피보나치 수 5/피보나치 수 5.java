import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(fibo(num));
	}

	private static int fibo(int num) {
		if (num == 1) return 1;
		if (num == 0) return 0;		
		return fibo(num - 1) + fibo(num - 2);
	}
}
