import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 로또 번호 Map에 모두 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 46; i++) map.put(i, 0);
        // 당첨 번호는 값을 1로 변경
        for (int i = 0; i < 6; i++) map.put(win_nums[i], 1);
        // 0의 개수와 당첨 번호 개수
        int zero = 0;
        int win = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            if (map.get(lottos[i]) == 1) win++;
        }
        // 0의 개수와 당첨 번호 개수의 합에 따라 등수 출력하도록 배열 생성
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = {rank[win + zero], rank[win + 0]};

        return answer;
    }
}