public class Solution {
    public int solution(String s) {
        int answer = 0;
        
		StringBuilder sb = new StringBuilder();
		String[] input = s.replaceAll("\"", "").split("");
		String[] number = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] str = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			int cnt = 0;
			for (int j = 0; j < number.length; j++) {
				if (input[i].equals(number[j])) {
					sb.append(input[i]);
					break;
				}
				cnt++;
				if (cnt == 10) sb2.append(input[i]);
			}
			for (int j = 0; j < str.length; j++) {
				if (str[j].equals(sb2.toString())) {
					sb.append(number[j]);
					sb2.setLength(0);
				}
			}
		}
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}