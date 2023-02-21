import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int H, W, r, c;
	static String[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			r = 0;
			c = 0;
			
			map = new String[H][W];
			
			for (int i = 0; i < H; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = input[j];
					if (input[j].equals("<") || input[j].equals(">") || input[j].equals("^") || input[j].equals("v")) {
						r = i;
						c = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String[] order = br.readLine().split("");
			for (int i = 0; i < N; i++) tank(r, c, order[i]);
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}

	private static void tank(int x, int y, String order) {
		switch (order) {
		case "U":
			if (isInRange(x - 1, y) && map[x - 1][y].equals(".")) {
				map[x][y] = ".";
				map[x - 1][y] = "^";
				r -= 1;
				return;
			}
			map[x][y] = "^";
			break;
		case "D":
			if (isInRange(x + 1, y) && map[x + 1][y].equals(".")) {
				map[x][y] = ".";
				map[x + 1][y] = "v";
				r += 1;
				return;
			}
			map[x][y] = "v";
			break;
		case "L":
			if (isInRange(x, y - 1) && map[x][y - 1].equals(".")) {
				map[x][y] = ".";
				map[x][y - 1] = "<";
				c -= 1;
				return;
			}
			map[x][y] = "<";
			break;
		case "R":
			if (isInRange(x, y + 1) && map[x][y + 1].equals(".")) {
				map[x][y] = ".";
				map[x][y + 1] = ">";
				c += 1;
				return;
			}
			map[x][y] = ">";
			break;
		case "S":
			shoot(x, y, map[x][y]);
			break;
		}
	}

	private static void shoot(int x, int y, String dir) {
		switch (dir) {
		case "^":
			while(true) {
				if (!isInRange(x - 1, y)) break;
				if (map[x - 1][y].equals("#")) break;
				if (map[x - 1][y].equals("*")) {
					map[x - 1][y] = ".";
					break;
				}
				x -= 1;
			}
			break;
		case "v":
			while(true) {
				if (!isInRange(x + 1, y)) break;
				if (map[x + 1][y].equals("#")) break;
				if (map[x + 1][y].equals("*")) {
					map[x + 1][y] = ".";
					break;
				}
				x += 1;
			}
			
			break;
		case "<":
			while(true) {
				if (!isInRange(x, y - 1)) break;
				if (map[x][y - 1].equals("#")) break;
				if (map[x][y - 1].equals("*")) {
					map[x][y - 1] = ".";
					break;
				}
				y -= 1;
			}
			break;
		case ">":
			while(true) {
				if (!isInRange(x, y + 1)) break;
				if (map[x][y + 1].equals("#")) break;
				if (map[x][y + 1].equals("*")) {
					map[x][y + 1] = ".";
					break;
				}
				y += 1;
			}
			break;
		}
	}

	private static boolean isInRange(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
