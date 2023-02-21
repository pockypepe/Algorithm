import java.io.*;

public class Main {
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(sb.toString());
	}

	private static void cut(int r, int c, int size) {
		int sum = 0;
		
		for (int i = r, rEnd = r + size; i < rEnd; i++) {
			for (int j = c, cEnd = c + size; j < cEnd; j++) {
				sum += map[i][j];
			}
		}
		
		if (sum == size * size) sb.append("1");
		else if (sum == 0) sb.append("0");
		else {
			int half = size / 2;
			sb.append("(");
			cut(r, c, half);
			cut(r, c + half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);
			sb.append(")");
		}
	}
}
