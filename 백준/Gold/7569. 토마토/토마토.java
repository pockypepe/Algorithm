import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H, ans;
    static int[] dx = {-1, 1, 0, 0, 0, 0}, dy = {0, 0, -1, 1, 0, 0}, dz = {0, 0, 0, 0, -1, 1};
    static int[][][] map;
    static boolean[][][] visited;
    static List<int[]> tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        H = Integer.parseInt(st.nextToken()); // z

        map = new int[H][N][M]; // z x y
        visited = new boolean[H][N][M];
        tomato = new ArrayList<>();

        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) tomato.add(new int[] {i, j, k, 0}); // z x y level
                }
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

            if (visited[current[0]][current[1]][current[2]]) continue;
            visited[current[0]][current[1]][current[2]] = true;
            days = Math.max(days, current[3]);
            
            for (int d = 0; d < 6; d++){
                int nx = current[1] + dx[d];
                int ny = current[2] + dy[d];
                int nz = current[0] + dz[d];
                if (isInRange(nx, ny, nz) && !visited[nz][nx][ny] && map[nz][nx][ny] != -1){
                	map[nz][nx][ny] = 1;
                    queue.offer(new int[]{nz, nx, ny, current[3] + 1});
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) cnt++;
                }
            }
        }

        if (cnt == 0) ans = days;
        else ans = -1;

    }

    private static boolean isInRange(int nx, int ny, int nz){
        return 0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H;
    }
}