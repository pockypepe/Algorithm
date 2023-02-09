import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] dna = {"A", "C", "G", "T"};
		int[] input = new int[4];
		int[] count = new int[4];
		
		String[] str = br.readLine().split("");
		String[] subStr = new String[N];
		
		
		st = new StringTokenizer(br.readLine());
		// 입력 저장
		for (int i = 0; i < 4; i++) input[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for (int i = 0; i < M; i++) {
			subStr[i] = str[i];
			for (int j = 0; j < 4; j++) {
				if (dna[j].equals(subStr[i])) count[j]++;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (input[i] <= count[i]) cnt++;
		}
		if (cnt == 4) ans++;

		for (int t = 0; t < N - M; t++) {
			
			switch (subStr[t]) {
			case "A": 
				count[0]--;
				break;
			case "C": 
				count[1]--;
				break;
			case "G": 
				count[2]--;
				break;
			case "T": 
				count[3]--;
				break;
			}
			
			subStr[t] = null;
			
			switch (str[t + M]) {
			case "A": 
				count[0]++;
				break;
			case "C": 
				count[1]++;
				break;
			case "G": 
				count[2]++;
				break;
			case "T": 
				count[3]++;
				break;
			}
			
			subStr[t + M] = str[t + M];

			// 개수 맞는지 확인
			int Cnt = 0;
			for (int i = 0; i < 4; i++) {
				if (input[i] <= count[i]) Cnt++;
			}
			if (Cnt == 4) ans++;
		}
		
		System.out.println(ans);
		
	}
}