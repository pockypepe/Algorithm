import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    private static void getLength(int a, int b, int c) {
        if (c != -1 && (a >= c || b >= c)) {
            sb.append("Impossible.\n");
            return;
        }
        double distance = 0;
        if (a == -1) {
            distance = Math.sqrt((c * c - b * b));
            sb.append("a = ");
        }
        else if (b == -1) {
            distance = Math.sqrt(c * c - a * a);
            sb.append("b = ");
        }
        else {
            distance = Math.sqrt(a * a + b * b);
            sb.append("c = ");
        }
        sb.append(String.format("%.3f", distance) + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b== 0 && c ==0) break;

            sb.append("Triangle #" + tc++ + "\n");

            getLength(a, b, c);

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
