/*
    1. 반복을 돌면서 몇일이 걸리는지 계산
        (100 - progress) / speed의 올림
    2. 방문 체크를 하면서 반복 돌기
    3. 앞의 원소가 뒤의 원소 보다 크면 cnt 올려줌
    4. 앞의 원소가 뒤의 원소 보다 작다면 현재 cnt를 list에 넣기
 */
import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int[] days = new int[progresses.length];
        boolean[] visited = new boolean[progresses.length];
        for (int i = 0; i < days.length; i++) days[i] = (int) Math.ceil(1.0 * (100 - progresses[i]) / speeds[i]);

        for (int i = 0; i < days.length; i++) {
            if (visited[i]) continue;
            int cnt = 1;
            visited[i] = true;
            for (int j = i + 1; j < days.length; j++) {
                if (days[i] >= days[j]) {
                    visited[j] = true;
                    cnt++;
                }
                else break;
            }
            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}