import java.util.*;

class Solution {
    static class Truck {
        int weight, time;
        
        Truck (int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int pointer = 0;
        
        Queue<Truck> q = new ArrayDeque();
        q.offer(new Truck(0, 0));
        
        while (pointer != truck_weights.length || !q.isEmpty()) {
            Truck cur = q.peek();
            
            if (answer - cur.time == bridge_length) {
                sum -= cur.weight;
                q.poll();
            }
            
            if (q.size() <= bridge_length
                && pointer != truck_weights.length
                && sum + truck_weights[pointer] <= weight) {
                q.offer(new Truck(truck_weights[pointer], answer));
                sum += truck_weights[pointer];
                pointer++;
            }
            
            answer++;
        }
        return answer;
    }
}