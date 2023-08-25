import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int oh = t / 60;
        int om = t % 60;

        m += om;
        if (m >= 60) {
            m -= 60;
            h += 1;
        }

        h += oh;
        h = h >= 24 ? h - 24 : h;

        System.out.println(h + " " + m);
    }
}