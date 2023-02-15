import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");
		int sum = 0;
		for(int i = 0; i < l; i++) {
			sum += (arr[i].charAt(0) - 'a' + 1) * (Math.pow(31, i) % 1234567891);
		}
		System.out.println(sum % 1234567891);
	}
}