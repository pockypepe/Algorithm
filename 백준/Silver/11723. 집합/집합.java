import java.io.*;
import java.util.*;

public class Main {
    static int[] set;
    static StringBuilder sb;

    private static void orperation(String order, int num) {
        if (order.equals("add")) set[num] = 1;
        else if (order.equals("remove")) set[num] = 0;
        else if (order.equals("check")) sb.append(set[num] + "\n");
        else if (order.equals("toggle")) {
            if (set[num] == 1) set[num] = 0;
            else set[num] = 1;
        }
    }

    private static void operation2(String order) {
        if (order.equals("all")) Arrays.fill(set, 1);
        else Arrays.fill(set, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        set = new int[21];
        sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("all") || order.equals("empty")) operation2(order);
            else {
                int num = Integer.parseInt(st.nextToken());
                orperation(order, num);
            }
        }

        System.out.println(sb.toString());
    }
}
