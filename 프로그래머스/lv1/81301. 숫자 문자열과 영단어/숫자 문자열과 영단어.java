class Solution {
    public int solution(String s) {
    	String[] str = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	
    	for (int i = 0; i < str.length; i++) {
    		s = s.replaceAll(str[i], String.valueOf(i));
    	}
    	
    	return Integer.parseInt(s);
    }
}