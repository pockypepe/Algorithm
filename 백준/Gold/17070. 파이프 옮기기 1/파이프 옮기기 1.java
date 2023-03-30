import java.io.*;
import java.util.*;
/*
    1. 큐에 시작점과 끝점의 좌표를 배열로 저장
    2. 파이프의 방향이 어떤 방향이어도 대각선은 항상 체크
    3. 조건에 따라 가로, 세로 체크
    4. 만약 끝점이 목표점에 도달하면 1 증가
 */
public class Main {
    static int N, ans;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int[][] map;

    private static void pipeMove(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }

        switch (dir) {
            case 0 :
                if (checkGaro(x, y)) pipeMove(x, y + 1, 0);
                break;
            case 1 :
                if (checkSero(x, y)) pipeMove(x + 1, y, 1);
                break;
            case 2 :
                if (checkGaro(x, y)) pipeMove(x, y + 1, 0);
                if (checkSero(x, y)) pipeMove(x + 1, y, 1);
                break;
        }

        if (checkCross(x, y)) pipeMove(x + 1, y + 1, 2);
    }

    private static boolean checkGaro(int x, int y) {
        if (isInRange(x, y + 1) && map[x][y + 1] != 1) return true;
        return false;
    }

    private static boolean checkSero(int x, int y) {
        if (isInRange(x + 1, y) && map[x + 1][y] != 1) return true;
        return false;
    }
    private static boolean checkCross(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInRange(nx, ny) && map[nx][ny] != 1) continue;
            return false;
        }
        return true;
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        pipeMove(0, 1, 0);

        System.out.println(ans);
    }
}