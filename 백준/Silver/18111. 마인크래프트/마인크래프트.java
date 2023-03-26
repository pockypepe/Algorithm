import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B, T, H;
    static int[][] map;
    static PriorityQueue<Integer> pq;

    private static void makeFlat(int height) {
        int time = 0;
        int storage = B;
        for (int i : pq) {
            if (height > i) {
                // 블록 쌓기
                time += (height - i);
                storage -= (height - i);
            } else {
                // 블록 파기
                time += (i - height) * 2;
                storage += (i - height);
            }
            // 내림차순이라 인벤토리에 블록이 없다는 뜻은 땅을 평평하게 만들기가 불가능
            if (storage < 0) return;
        }
        // 맞춰야하는 높이에서 걸리는 시간
        if (T >= time) {
            T = time;
            H = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        T = Integer.MAX_VALUE;
        H = 0;
        map = new int[N][M];
        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.offer(map[i][j]);
            }
        }

        for (int i = 0; i < 257; i++) makeFlat(i);

        System.out.println(T + " " + H);
    }
}