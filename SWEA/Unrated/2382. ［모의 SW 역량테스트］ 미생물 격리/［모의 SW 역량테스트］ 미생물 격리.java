import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K, ans;
    static int[][] d = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Minions {
        int x, y, num, dir;

        public Minions(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

    private static void moveMinions(int time, List<Minions> list) {
        if (time == M) {
            for (Minions m : list) ans += m.num;
            return;
        }
        List<Minions> newList = new ArrayList<>();
        Minions[][] map = new Minions[N][N];
        PriorityQueue<Minions> pq = new PriorityQueue<>((o1, o2) -> o2.num - o1.num);
        for (Minions m : list) {
            // 방향에 맞게 이동
            m.x += d[m.dir][0];
            m.y += d[m.dir][1];
            // 빨간 구역에 들어왔다면 미생물 수 반으로 줄이고 방향 전환
            if (isInRange(m.x, m.y)) {
                m.num /= 2;
                m.dir = m.dir % 2 == 0 ? (m.dir + 4) % 5 : (m.dir + 6) % 5;
            }
            // 이동한 위치에 추가하기
            pq.offer(m);
        }

        while (!pq.isEmpty()) {
            Minions cur = pq.poll();
            if (map[cur.x][cur.y] == null) map[cur.x][cur.y] = cur;
            else map[cur.x][cur.y] = new Minions(cur.x, cur.y, map[cur.x][cur.y].num + cur.num, map[cur.x][cur.y].dir);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null) continue;
                newList.add(map[i][j]);
            }
        }
        moveMinions(time + 1, newList);
    }

    private static boolean isInRange(int x, int y) {
        return x == 0 || x == N - 1 || y == 0 || y == N - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;

            List<Minions> list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list.add(new Minions(x, y, num, dir));
            }

            moveMinions(0, list);

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
