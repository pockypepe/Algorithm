/*
    무적권을 먼저 사용한다고 생각
    우선순위 큐의 크기가 무적권의 크기보다 클 때까지 넣기
    큐의 크기가 더 크다면 우선순위 큐에서 제일 작은 값을 꺼내서 직접 처리했다고 생각
    반복하다 현재 병사보다 작을 때 정답 출력
*/

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            
            if (pq.size() > k) n -= pq.poll();
            if (n < 0) return i;
        }
        return answer;
    }
}