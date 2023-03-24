import java.util.*;

class Solution {
        public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] data = record[i].split(" ");
            if (data[0].equals("Enter")) {
                map.put(data[1], data[2]);
                list.add(new String[]{data[1], "님이 들어왔습니다."});
            } else if (data[0].equals("Leave")) {
                list.add(new String[]{data[1], "님이 나갔습니다."});
            } else {
                map.put(data[1], data[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        
        return answer;
    }
}