class Solution {
    static int ans, N;
    static int[] lion, apeach, temp, close;

    public static int[] solution(int n, int[] info) {
        ans = 0;
        N = n;
        apeach = info;
        temp = new int[N];

        combination(0, 0);

        int[] answer = null;
        if (ans == 0) answer = new int[]{-1};
        else answer = close.clone();

        return answer;
    }
    // 중복조합
    private static void combination(int cnt, int start) {
        if (cnt == N) {
            compareApeach();
            return;
        }
        for (int i = start; i < 11; i++) {
            temp[cnt] = i;
            combination(cnt + 1, i);
        }
    }

    private static void compareApeach() {
        lion = new int[11];
        for (int i : temp) lion[i]++;

        int apeachScore = 0;
        int lionScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue;
            if (apeach[i] < lion[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;
        }
        int gap = lionScore - apeachScore;
        if (ans == gap && gap == 0) return;
        if (ans > gap) return;
        if (ans < gap) {
            ans = gap;
            close = lion.clone();
        } else if (ans == gap) compareLess();
    }

    private static void compareLess() {
        for (int i = 10; i >= 0; i--) {
            if (close[i] == lion[i]) continue;
            if (close[i] > lion[i]) return;
            if (close[i] < lion[i]) close = lion.clone();
            return;
        }
    }
}