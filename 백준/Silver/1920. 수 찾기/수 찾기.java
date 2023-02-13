import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] compare = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) compare[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int[] input = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) input[i] = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		
		Arrays.sort(compare);
		
		for(int i = 0; i < M; i++) {
			binarySearch(compare, input[i]);
		}
		
		System.out.println(sb.toString());		
	}

	private static void binarySearch(int[] compare, int s) {
		int start = 0;
		int end = compare.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (compare[mid] < s) start = mid + 1;
			else if (compare[mid] > s) end = mid - 1;
			else {
				sb.append(1).append("\n");
				return;
			}
		}
		sb.append(0).append("\n");
		return;
	}
}