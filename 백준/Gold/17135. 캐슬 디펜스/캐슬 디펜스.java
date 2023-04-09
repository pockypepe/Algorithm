import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, D, sum, ans;
    static List<Enemy> list;

    static class Enemy {
        int x, y;

        Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void findEnemy(int[] archers) {
        List<Enemy> copy = new ArrayList<>();
        for (Enemy e : list) copy.add(new Enemy(e.x, e.y));

        while (true) {
            Set<Enemy> set = new HashSet<>();

            for (int i : archers) {
                Enemy enemy = attackEnemy(i, copy);
                if (enemy != null) set.add(enemy);
            }
            
            for (Enemy e : set) {
                copy.remove(e);
                sum++;
            }
            moveEnemy(copy);

            if (copy.size() == 0) break;
        }

        ans = Math.max(ans, sum);
    }

    private static Enemy attackEnemy(int archer, List<Enemy> copy) {
        PriorityQueue<Enemy> pq = new PriorityQueue<>((o1, o2) -> {
            int d1 = N - o1.x + Math.abs(o1.y - archer);
            int d2 = N - o2.x + Math.abs(o2.y - archer);
            if (d1 == d2) return o1.y - o2.y;
            return d1 - d2;
        });
        for (Enemy e : copy) {
            int distance = Math.abs(e.x - N) + Math.abs(e.y - archer);
            if (distance <= D) pq.offer(e);
        }
        return pq.poll();
    }

    private static void moveEnemy(List<Enemy> copy) {
        for (int i = 0; i < copy.size(); i++) {
            Enemy e = copy.get(i);
            if (e.x == N - 1) {
                copy.remove(e);
                i--;
            }
            else e.x += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) list.add(new Enemy(i, j));
            }
        }

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    sum = 0;
                    findEnemy(new int[] {i, j ,k});
                }
            }
        }

        System.out.println(ans);
    }
}
