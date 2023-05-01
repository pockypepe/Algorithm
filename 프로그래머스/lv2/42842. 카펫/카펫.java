class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        int first = sum;
        int second = 1;
        while (first >= second) {
            if ((first + second) * 2 - 4 == brown
               && (first - 2) * (second - 2) == yellow) {
                answer = new int[] {first, second};
                break;
            }
            first--;
            if (sum % first == 0) second = sum / first;
        }
        return answer;
    }
}