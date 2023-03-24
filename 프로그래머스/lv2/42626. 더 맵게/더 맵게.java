import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) pq.offer(scoville[i]);

        int answer = 0;
        while (pq.size() != 1) {
            int min = pq.poll();
            if (min >= k) break;

            int second = pq.poll();

            pq.offer(min + second * 2);
            answer++;
        }

        return pq.poll() < k ? -1 : answer;
    }
}