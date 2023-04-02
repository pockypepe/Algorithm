import java.io.*;
import java.util.*;
/*
    1. 그리디
    2. 회의를 종료시간 기준 오름차순 정렬
    3. 만약 종료시간이 같다면 시작시간 오름차순
    4. list의 마지막 회의 종료시간이 다음 회의 시작 시간보다 작거나 같으면 이어 붙이기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] =new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        List<int[]> list = new ArrayList<>();
        list.add(meetings[0]);
        for (int i = 1; i < N; i++) {
            if (list.get(list.size() - 1)[1] <= meetings[i][0]) list.add(meetings[i]);
        }

        System.out.println(list.size());
    }
}