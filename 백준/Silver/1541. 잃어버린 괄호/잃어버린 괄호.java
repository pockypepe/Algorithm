import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int[] num = new int[input.length];
        int idx = 0;
        for (String s : input) {
            String[] temp = s.split("\\+");
            int sum = 0;
            for (String t : temp) sum += Integer.parseInt(t);
            num[idx++] = sum;
        }

        int ans = num[0] * 2;
        for (int i : num) ans -= i;

        System.out.println(ans);
    }
}