class Solution {
    static int answer;
    
    public static void makeNum(int[] numbers, int target, int cnt, int sum) {
        if (cnt == numbers.length) {
            if (target == sum) answer++;
            return;
        }

        makeNum(numbers, target, cnt + 1, sum + numbers[cnt]);
        makeNum(numbers, target, cnt + 1, sum - numbers[cnt]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        makeNum(numbers, target, 0, 0);
        return answer;
    }
}