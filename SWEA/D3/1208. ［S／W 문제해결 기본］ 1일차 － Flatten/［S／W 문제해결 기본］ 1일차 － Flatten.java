import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc < 11; tc++) {
			int dump = Integer.parseInt(br.readLine());
			String[] inputs = br.readLine().split(" ");
			int[] box = new int[inputs.length];
			for (int i = 0; i < inputs.length; i++) {
				box[i] = Integer.parseInt(inputs[i]);
			}
			System.out.printf("#%d %d\n", tc, ans(dump, box));
		}		
	}

	private static int ans(int dump, int[] box) {
		if (dump == 0) return box[box.length - 1] - box[0];
		Arrays.sort(box);
		box[0] += 1;
		box[box.length - 1] -= 1;
		Arrays.sort(box);
		return ans(dump - 1, box);
	}
}