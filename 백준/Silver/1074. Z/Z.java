import java.util.Scanner;

public class Main {
	static int N, r, c, cnt;
	static int[] dr = {0, 0, 1, 0}, dc = {0, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2, sc.nextInt());
		r = sc.nextInt();
		c = sc.nextInt();
		
		Z(0, 0, N);
		
		System.out.println(cnt - 1);
	}

	private static void Z(int x, int y, int size) {
		int dir = 0;
		if (size == 2) {
			for (int i = 0; i < 4; i++) {
				x += dr[dir];
				y += dc[dir];
				dir++;
				cnt++;
				if (x == r && y == c) return;
			}
		} else {
			int half = size / 2;
			if (x <= r && r < x + half && y <= c && c < y + half) {
				cnt += 0;
				Z(x, y, half);
			}
			else if (x <= r && r < x + half && y + half <= c && c < y + size) {
				cnt += (int) Math.pow(half, 2);
				Z(x, y + half, half);
			}
			else if (x + half <= r && r < x + size && y <= c && c < y + half) {
				cnt += (int) Math.pow(half, 2) * 2;
				Z(x + half, y, half);
			}
			else {
				cnt += (int) Math.pow(half, 2) * 3;
				Z(x + half, y + half, half);			
			}
		}
	}
}