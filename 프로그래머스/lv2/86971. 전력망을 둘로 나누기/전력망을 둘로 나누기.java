import java.util.*;

class Solution {
    static int[][] map;
    static boolean[] visited;
    
    public static int countNode(int n) {
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) q.offer(j);
            }
            if (!q.isEmpty()) {
                visited[i] = true;
                break;
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur]) continue;
            visited[cur] = true;
            
            for (int i = 1; i <= n; i++) {
                if (map[cur][i] == 1 && !visited[i]) q.offer(i);
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) if (visited[i]) count++;
        
        int ops = n - count;
        
        return Math.abs(count - ops);
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new int[n + 1][n + 1];
        
        for (int[] i : wires) {
            map[i[0]][i[1]] = 1;
            map[i[1]][i[0]] = 1;
        }
        
        for (int[] cut : wires) {
            map[cut[0]][cut[1]] = 0;
            map[cut[1]][cut[0]] = 0;
            visited = new boolean[n + 1];
            answer = Math.min(answer, countNode(n));
            map[cut[0]][cut[1]] = 1;
            map[cut[1]][cut[0]] = 1;
        }
        
        return answer;
    }
}