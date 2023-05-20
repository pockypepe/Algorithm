import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 1. 뱀은 항상 (1, 1) 위치에서 시작 -> 먼저 오른쪽으로 매초 이동
     * 2. 사과를 먹으면 머리만 늘어남
     *    큐에 머리 부분만 offer
     * 3. 사과가 없다면 꼬리가 있던 자리를 비워줌 -> 큐를 사용?
     *    이동하면 큐애서 poll하고 머리가 될 부분을 offer 해줌
     * 4. 맵이 존재하고 뱀의 존재 (큐에 있는 점)들을 방문 체크하면서 머리가 몸에 부딪혔는지 확인
     */
    static int N, ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] D = {1, 2, 3, 0};
    static int[] L = {3, 0 , 1, 2};
    static int[][] map, visited;
    static List<Snake> snake;
    static Map<Integer, String> route;

    static class Snake {
        int x, y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void moveSnake(int x, int y) {
        snake = new ArrayList<>();
        snake.add(new Snake(x, y));
        visited[x][y] = 1;

        // 맨 처음 방향은 오른쪽
        int dir = 1;
        // 현재 게임 시간
        ans = 1;

        while (snake.size() != 0) {
            // 머리 부분 가져오기
            int size = snake.size();
            Snake cur = snake.get(size - 1);

            /**
             상 우 하 좌
             D : 오른쪽 L : 왼쪽
             0 이면 D1, L3
             1 이면 2, 0
             2 이면 3, 1
             3 이면 0, 2
             */

            // route.get(ans)에 따라 방향 바꾸기 -> null 이면 현재 방향 유지
            String d = route.get(ans - 1);
            if (d == null) dir = dir;
            else if (d.equals("D")) dir = D[dir];
            else if (d.equals("L")) dir = L[dir];

            // 이동할 곳
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            // 벽을 만난다면 while문 밖으로 나가기
            if (!isInRange(nx, ny)) break;

            // 뱀의 머리와 몸통이 만난다면 while문 밖으로 나가기
            if (visited[nx][ny] == 1) break;
            visited[nx][ny] = 1;

            // 사과를 먹었다면 머리만 증가
            // 사과를 안먹었으면 꼬리 부분 방문 해제 후 제거 -> 머리 추가
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new Snake(nx, ny));
            } else {
                Snake tail = snake.get(0);
                visited[tail.x][tail.y] = 0;
                snake.remove(tail);
                snake.add(new Snake(nx, ny));
            }
            // 게임 시간 증가
            ans++;
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        // 사과의 위치 받기
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        // 움직일 경로 Map 형식으로 저장
        route = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            route.put(second, dir);
        }

        moveSnake(0, 0);

        System.out.println(ans);
    }
}
