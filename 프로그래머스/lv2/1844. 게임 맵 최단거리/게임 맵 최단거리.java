import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int moveRobot(int x, int y, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {x, y, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            
            if (maps[cur[0]][cur[1]] == -1) continue;
            maps[cur[0]][cur[1]] = -1;
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (isInRange(nx, ny, n, m) && maps[nx][ny] == 1)
                    q.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        return -1;
    }
    
    public static boolean isInRange(int nx, int ny, int n, int m) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }
    
    public int solution(int[][] maps) {
        int answer = moveRobot(0, 0, maps);
        return answer;
    }
}