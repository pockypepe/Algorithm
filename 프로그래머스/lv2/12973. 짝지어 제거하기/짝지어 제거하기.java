import java.util.Stack;

class Solution {
    public static int solution(String string) {
        Stack<Character> stack = new Stack<>();
        stack.push('0');

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == stack.peek()) stack.pop();
            else stack.push(string.charAt(i));
        }

        int answer = stack.size() > 1? 0 : 1;

        return answer;
    }
}