import java.util.*;
import java.lang.*;

class Solution {
    static boolean[] visited;
    static int[] group;
    
    public static void dfs (int x, int y, int n, int[][] computers) {
        if (visited[y]) return;
        visited[y] = true;
        group[y] = group[x];
        
        for (int i = 0; i < n; i++) {
            if (y != i && computers[y][i] == 1 && !visited[i]) dfs(y, i, n, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        group = new int[n];
        
        int lvl = 1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) group[i] = lvl;
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) dfs(i, j, n, computers); 
            }
            lvl++;
        }
        
        Set<Integer> s = new HashSet<Integer>();
        for (int a : group) s.add(a);
        
        int answer = s.size();
        return answer;
    }
}