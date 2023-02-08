import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] snail = new int[n][n];
			int[] dx = {0, 1, 0, -1}; // 오른쪽 아래 왼쪽 위
			int[] dy = {1, 0, -1, 0};
			int x = 0;
			int y = 0;
			int z = 0;
			
			
			for (int i = 1; i <= n * n; i++) {
				snail[x][y] = i;
				x += dx[z];
				y += dy[z];
				if (x >= n || y >= n || x < 0 || y < 0 || snail[x][y] != 0) {
					x -= dx[z];
					y -= dy[z];
					z = (z + 1) % 4;
					x += dx[z];
					y += dy[z];
				}
			}
			
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
}