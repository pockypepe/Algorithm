import java.io.*;
import java.util.*;

/*
    1. 맨 앞 초밥의 수가 1이면 개수에서 1 빼기
    2. 맨 앞 초밥의 수가 1이 아니면 유지
    3. 맨 뒤 초밥의 수가 0이면 1 추가
    4. 맨 뒤 초밥의 수가 0이 아니면 유지
    5. 쿠폰의 초밥은 처음 같이 계산
 */
public class Main {
    static int N, d, k ,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[2 * N];
        for (int i = 0; i < N; i++) sushi[i] = sushi[i + N] = Integer.parseInt(br.readLine());

        int[] eat = new int[d + 1];

        int start = 0;
        int end = k - 1;
        for (int i = start; i <= end; i++) eat[sushi[i]]++;
        eat[c]++;

        int ans = 0;
        int cnt = 0;
        for (int i = 1; i <= d; i++) {
            if (eat[i] != 0) cnt++;
        }
        ans = cnt;

        while (start != N) {
            if (eat[sushi[start]] == 1) cnt--;
            eat[sushi[start]]--;
            start++;
            end++;
            if (eat[sushi[end]] == 0) cnt++;
            eat[sushi[end]]++;
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}