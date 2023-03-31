import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            long[] input = new long[N];
            long[] c = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) input[i] = Long.parseLong(st.nextToken());

            int size = 0;
            for (int i = 0; i < N; i++) {
                int temp = Arrays.binarySearch(c, 0, size, input[i]);
                temp = Math.abs(temp) - 1;
                c[temp] = input[i];
                if (temp == size) size++;
            }

            System.out.println("#" + tc + " " + size);
        }
    }
}