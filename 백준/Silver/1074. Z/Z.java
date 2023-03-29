import java.io.*;
import java.util.*;

public class Main {
    static int r, c, ans;

    private static void diviedSection(int startR, int startC, int range, int nth) {
        if (range == 1) {
            if (startR == r && startC == c) ans = nth;
            else if (startR == r && startC + 1 == c) ans = nth + 1;
            else if (startR + 1 == r && startC == c) ans = nth + 2;
            else ans = nth + 3;
            return;
        }

        int next = (int) Math.pow(2, range - 1);
        int sum = next * next;

        if (r < startR + next && c < startC + next)
            diviedSection(startR, startC, range - 1, nth);
        else if (r < startR + next && c >= startC + next)
            diviedSection(startR, startC + next, range - 1, nth + sum);
        else if (r >= startR + next && c < startC + next)
            diviedSection(startR + next, startC, range - 1, nth + sum * 2);
        else
            diviedSection(startR + next, startC + next, range - 1, nth + sum * 3);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        diviedSection(0, 0, N, 0);

        System.out.println(ans);
    }
}