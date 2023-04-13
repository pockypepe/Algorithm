import java.util.*;

class Solution {
    public static int[] solution(int[] fees, String[] records) {
        Map<String, int[]> parking = new HashMap<>();
        Map<String, Integer> sumTime = new HashMap<>();

        for (String s : records) {
            String[] temp = s.split(" ");
            String[] time = temp[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);

            if (temp[2].equals("IN")) parking.put(temp[1], new int[] {hour, min});
            else {
                int[] enter = parking.get(temp[1]);
                sumTime.put(temp[1], sumTime.getOrDefault(temp[1], 0) + timeCheck(enter, hour, min));
                parking.remove(temp[1]);
            }
        }
        // 맵에 남아 있는 차 -> 입차는 했지만 출차 안한 차
        for (String key : parking.keySet()) {
            int[] enter = parking.get(key);
            if (sumTime.get(key) != null) sumTime.put(key, sumTime.get(key) + timeCheck(enter, 23, 59));
            else sumTime.put(key, timeCheck(enter, 23, 59));
        }
        // 요금 계산하기
        int[] answer = payFee(fees, sumTime);

        return answer;
    }

    private static int[] payFee(int[] fees, Map<String, Integer> sumTime) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int t = fees[2];
        int tf = fees[3];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (String key : sumTime.keySet()) {
            int sum = sumTime.get(key);
            int price = 0;
            if (sum > basicTime) {
                sum -= basicTime;
                int change = (sum % t == 0) ? 0 : 1;
                price = basicFee + (sum / t + change) * tf;
            } else price = basicFee;
            pq.offer(new int[] {Integer.parseInt(key), price});
        }
        int[] ans = new int[pq.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = pq.poll()[1];

        return ans;
    }

    private static int timeCheck(int[] enter, int hour, int min) {
        // enter 들어온 시간
        int[] total = new int[2];
        if (min - enter[1] < 0) {
            total[0] = hour - 1 - enter[0];
            total[1] = min - enter[1] + 60;
        } else {
            total[0] = hour - enter[0];
            total[1] = min - enter[1];
        }
        return total[0] * 60 + total[1];
    }
}