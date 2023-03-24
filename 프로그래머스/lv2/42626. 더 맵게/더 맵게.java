import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int k) {
        // 우선 순위 큐를 사용해 자동 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) pq.offer(scoville[i]);

        int answer = 0;
        // pq의 사이즈가 1개면 더 이상 음식을 섞을 수 없음
        // 동시에 조건에 맞는 음식을 만들 수 없을 가능성 있음
        while (pq.size() != 1) {
            int min = pq.poll();
            // 가장 먼저 꺼낸 수가 조건 K 보다 크다면 멈춤
            if (min >= k) break;

            int second = pq.poll();
            // 섞은 음식 다시 넣기
            pq.offer(min + second * 2);
            answer++;
        }
        // 만약 1개 남았을 시 꺼낸 음식이 조건 K 보다 작다면 불가능을 의미
        // 그게 아니라면 answer 출력
        return pq.poll() < k ? -1 : answer;
    }
}
