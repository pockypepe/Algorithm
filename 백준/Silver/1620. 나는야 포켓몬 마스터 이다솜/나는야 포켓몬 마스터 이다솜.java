import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] pocketmon = new String[N + 1];
        Map<String, Integer> keyIsName = new HashMap<>();
        
        for (int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            keyIsName.put(name, i);
            pocketmon[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (keyIsName.get(q) == null) {
                sb.append(pocketmon[Integer.parseInt(q)] + "\n");
            } else {
                sb.append(keyIsName.get(q) + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}