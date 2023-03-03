import java.io.*;
import java.util.*;

public class Main {
    static int M, N, ans;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        tomato = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) tomato.add(new int[] {i, j, 0});
            }
        }

        mature();

        System.out.println(ans);
    }

    private static void mature() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] i : tomato) queue.offer(i);
        
        int days = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            days = Math.max(days, current[2]);
            
            for (int d = 0; d < 4; d++){
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != -1){
                	map[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny, current[2] + 1});
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (map[i][j] == 0) cnt++;
        	}
        }

        if (cnt == 0) ans = days;
        else ans = -1;

    }

    private static boolean isInRange(int nx, int ny){
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}
