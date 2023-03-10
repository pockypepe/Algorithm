import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 알파벳 별로 List를 담을 배열 생성
        List<String[]>[] data = new ArrayList[52];
        for (int i = 0; i < 52; i++) data[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            // site의 첫 글자가 소문자이면 그대로 아니면 'A'를 빼주면서 index 관리
            int startAlphabet = site.charAt(0) - 'a';
            if (startAlphabet < 0) startAlphabet += 58;
            data[startAlphabet].add(new String[] {site, password});
        }
        // = site.charAt(0) - 'A'
        for (int i = 0; i < M; i++) {
            String search = br.readLine();
            int startAlphabet = search.charAt(0) - 'a';
            if (startAlphabet < 0) startAlphabet += 58;
            // site의 첫 글자의 List 중에서 검색
            for (String[] datas : data[startAlphabet]) {
                if (datas[0].equals(search)) {
                    sb.append(datas[1]).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}