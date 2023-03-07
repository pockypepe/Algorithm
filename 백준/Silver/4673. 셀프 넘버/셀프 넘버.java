public class Main {
    static boolean[] selfNum;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        selfNum = new boolean[10001];

        for (int i = 1; i < 10001 ; i++){
            if (selfNum[i]) continue;
            int a = i;
            int self = a;
            while (self <= 10000) {
                for (int d = 0; d < 5; d++){
                    self += a % 10;
                    a = a / 10;
                }
                if (self > 10000) break;
                selfNum[self] = true;
                a = self;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!selfNum[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}