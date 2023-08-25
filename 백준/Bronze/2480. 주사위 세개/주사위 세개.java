import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[7];
        for (int i = 0; i < 3; i++) input[Integer.parseInt(st.nextToken())]++;

        int ans = 0;

        for (int i = 1; i < 7; i++) {
            switch (input[i]) {
                case 1:
                    ans = Math.max(ans, i * 100);
                    break;
                case 2:
                    ans = 1000 + i *100;
                    break;
                case 3:
                    ans = 10000 + i * 1000;
            }
        }

        System.out.println(ans);
    }
}
