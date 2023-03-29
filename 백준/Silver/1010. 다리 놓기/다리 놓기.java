import java.io.*;
import java.util.*;

public class Main {
    static List<Long>[] list;

    private static void makeList() {
        list[1].add((long) 1);
        list[1].add((long) 1);
        for (int i = 2; i < 31; i++) {
            for (int j = 1; j <= list[i - 1].size() + 1; j++) {
                if (j == 1 || j == list[i - 1].size() +  1) list[i].add((long) 1);
                else list[i].add(list[i - 1].get(j - 2) + list[i - 1].get(j - 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        list = new List[31];
        for (int i = 0; i < 31; i++) list[i] = new ArrayList<>();
        makeList();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(list[M].get(N) + "\n");
        }

        System.out.println(sb.toString());
    }
}
