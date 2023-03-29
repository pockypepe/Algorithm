import java.util.HashMap;
import java.util.Map;

class Solution {
    static int[] right, left;
    static Map<Integer, int[]> keymap;

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        right = new int[]{3, 0};
        left = new int[]{3, 2};

        keymap = new HashMap<>();
        keymap.put(0, new int[] {3, 1});
        int key = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keymap.put(key++, new int[]{i, j});
            }
        }

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                left = keymap.get(i);
                continue;
            }
            if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                right = keymap.get(i);
                continue;
            }
            answer += whichHand(i, hand);
        }
        return answer;
    }

    private static String whichHand(int i, String hand) {
        int[] cur = keymap.get(i);
        int rd = Math.abs(cur[0] - right[0]) + Math.abs(cur[1] - right[1]);
        int ld = Math.abs(cur[0] - left[0]) + Math.abs(cur[1] - left[1]);

        if (rd < ld) {
            right = keymap.get(i);
            return "R";
        }
        if (ld < rd) {
            left = keymap.get(i);
            return "L";
        }

        if (hand.equals("left")) {
            left = keymap.get(i);
            return "L";
        } else {
            right = keymap.get(i);
            return "R";
        }
    }
}