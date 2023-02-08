import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) { // 나눌 것
			int cnt = 0;
			for (int j = 2; j < arr[i]; j++) { // 소수 체크 
				if (arr[i] % j == 0) break;
				cnt++;
			}
			if (cnt == (arr[i] - 2)) ans++;
		}
		System.out.println(ans);
	}
}