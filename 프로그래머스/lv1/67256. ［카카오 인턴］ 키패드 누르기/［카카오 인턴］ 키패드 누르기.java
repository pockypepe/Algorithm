import java.util.HashMap;
import java.util.Map;
/*
    1. Map에 키패드 저장
    2. 조건에 따라 오른손 왼손 위치 정보 변경
 */
class Solution {
    // 오른손 왼손 위치 배열로 저장
    static int[] right, left;
    static Map<Integer, int[]> keyPap;

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        right = new int[]{3, 0};
        left = new int[]{3, 2};
        // 키패드를 Map에 저장
        keyPap = new HashMap<>();
        keyPap.put(0, new int[] {3, 1});
        int key = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyPap.put(key++, new int[]{i, j});
            }
        }

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                left = keyPap.get(i);
                continue;
            }
            if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                right = keyPap.get(i);
                continue;
            }
            answer += whichHand(i, hand);
        }
        return answer;
    }

    private static String whichHand(int i, String hand) {
        int[] cur = keyPap.get(i);
        // 위치 계산
        int rd = Math.abs(cur[0] - right[0]) + Math.abs(cur[1] - right[1]);
        int ld = Math.abs(cur[0] - left[0]) + Math.abs(cur[1] - left[1]);

        if (rd < ld) {
            right = keyPap.get(i);
            return "R";
        }
        if (ld < rd) {
            left = keyPap.get(i);
            return "L";
        }

        if (hand.equals("left")) {
            left = keyPap.get(i);
            return "L";
        } else {
            right = keyPap.get(i);
            return "R";
        }
    }
}
