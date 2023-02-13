import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dpZero, dpOne;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			dpZero = new int[n + 1];
			dpOne = new int[n + 1];
			
			System.out.println(fiboZero(n) + " " + fiboOne(n));
		}
	}

	private static int fiboOne(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (dpOne[n] != 0) return dpOne[n];
		dpOne[n] = fiboOne(n - 1) + fiboOne(n - 2);
		return dpOne[n];
	}

	private static int fiboZero(int n) {
		if (n == 0) return 1;
		if (n == 1) return 0;		
		if (dpZero[n] != 0) return dpZero[n];
		dpZero[n] = fiboZero(n - 1) + fiboZero(n - 2);
		return dpZero[n];
	}
}
