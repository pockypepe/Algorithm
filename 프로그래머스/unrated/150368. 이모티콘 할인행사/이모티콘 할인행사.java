class Solution {
    static int[] answer, percent;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] sale = new int[emoticons.length];
        percent = new int[] {10, 20, 30, 40};
        answer = new int[2];

        perm(0, users, emoticons, sale);

        return answer;
    }

    private static void perm(int cnt, int[][] users, int[] emoticons, int[] sale) {
        if (cnt == sale.length) {
            maxProfit(users, emoticons, sale);
            return;
        }
        for (int i = 0; i < 4; i++) {
            sale[cnt] = percent[i];
            perm(cnt + 1, users, emoticons, sale);
        }
    }

    private static void maxProfit(int[][] users, int[] emoticons, int[] sale) {
        int cnt = 0;
        int profit = 0;

        for (int[] u :users) {
            int pay = 0;
            for (int e = 0; e < emoticons.length; e++) {
                if (u[0] > sale[e]) continue;
                pay += (emoticons[e] / 100) * (100 - sale[e]);
                if (pay >= u[1]) {
                    cnt++;
                    pay = 0;
                    break;
                }
            }
            profit += pay;
        }
        if (answer[0] < cnt) answer = new int[] {cnt, profit};
        else if (answer[0] == cnt) answer[1] = Math.max(answer[1], profit);
    }
}