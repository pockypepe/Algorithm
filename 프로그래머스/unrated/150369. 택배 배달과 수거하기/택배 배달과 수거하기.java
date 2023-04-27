import java.util.*;
import java.io.*;

class Solution {
    static Stack<Integer> deliv, pick;
    
    public static int moveTruck(int truck, Stack<Integer> stack) {
        int time = 0;
        
         while (!stack.isEmpty()) {
            if (truck == 0) break;
            int cur = stack.pop();
             
            if (cur == 0) continue;
            if (time == 0) time = stack.size() + 1;

            if (cur > truck) {
                stack.push(cur - truck);
                break;
            }
            else truck -= cur;
        }
        return time;
    }
    
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        deliv = new Stack<>();
        pick = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            deliv.push(deliveries[i]);
            pick.push(pickups[i]);
        }

        while (!deliv.isEmpty() || !pick.isEmpty()) {
            answer += Math.max(moveTruck(cap, deliv), moveTruck(cap, pick)) * 2;
        }
        
        return answer;
    }
}