import java.io.*;
import java.util.*;

public class Solution {
    static int N, ans;
    static List<int[]> stairs;
    static List<Person> list;

    static class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void movePerson(List<Person> select, List<Person> nonSelect) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (Person p : select) {
            pq1.offer(Math.abs(stairs.get(0)[0] - p.x) + Math.abs(stairs.get(0)[1] - p.y));
        }
        for (Person p : nonSelect) {
            pq2.offer(Math.abs(stairs.get(1)[0] - p.x) + Math.abs(stairs.get(1)[1] - p.y));
        }
        int time1 = 0;
        int time2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        while (!pq1.isEmpty()) {
            if (q1.size() < 3) {
                q1.offer(pq1.poll() + stairs.get(0)[2] + 1);
            } else if (q1.size() == 3) {
                int pre  = q1.poll();
                int next = pq1.poll();
                if (pre > next) q1.offer(pre + stairs.get(0)[2]);
                else q1.offer(next + stairs.get(0)[2] + 1);
            }
        }
        while (!q1.isEmpty()) {
            time1 = Math.max(time1, q1.poll());
        }
        if (time1 > ans) return;
        while (!pq2.isEmpty()) {
            if (q2.size() < 3) {
                q2.offer(pq2.poll() + stairs.get(1)[2] + 1);
            } else if (q2.size() == 3) {
                int pre  = q2.poll();
                int next = pq2.poll();
                if (pre > next) q2.offer(pre + stairs.get(1)[2]);
                else q2.offer(next + stairs.get(1)[2] + 1);
            }
        }
        while (!q2.isEmpty()) {
            time2 = Math.max(time2, q2.poll());
        }
        ans = Math.min(ans, Math.max(time1, time2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;
            stairs = new ArrayList<>();
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) list.add(new Person(i, j));
                    else if (temp > 1) stairs.add(new int[] {i, j, temp});
                }
            }

            for (int i = 0; i < (1 << list.size()); i++) {
                List<Person> select = new ArrayList<>();
                List<Person> nonSelect = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    if ((i & (1 << j)) != 0) nonSelect.add(new Person(list.get(j).x, list.get(j).y));
                    else select.add(new Person(list.get(j).x, list.get(j).y));
                }
                movePerson(select, nonSelect);
            }
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
