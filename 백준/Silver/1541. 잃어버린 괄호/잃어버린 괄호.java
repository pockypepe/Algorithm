import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        String[] input = br.readLine().split("-");
        for (String string : input[0].split("\\+")) {
            ans += Integer.parseInt(string);
        }

        for (int i = 1; i < input.length; i++) {
            for (String string : input[i].split("\\+")) ans -= Integer.parseInt(string);
        }

        System.out.println(ans);
    }
}