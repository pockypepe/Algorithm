import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int weight, height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Person[] personList = new Person[N];
        int[] rank = new int[N];

        Arrays.fill(rank, 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            personList[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (personList[i].weight < personList[j].weight && personList[i].height < personList[j].height) {
                    rank[i]++;
                }
            }
        }

        for (int r : rank) sb.append(r + " ");

        System.out.println(sb.toString());
    }
}
