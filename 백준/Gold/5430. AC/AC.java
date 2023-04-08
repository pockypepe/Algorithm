/*
    1. 배열로 모두 변환
    2. 정수 배열은 리스트로 바꾸기
    3. 함수의 모드에 따라 리버스 함수, 삭제 함수 사용
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, start, end;
    static boolean reverse, isPossible;
    static String[] function, arr;
    static StringBuilder sb;

    private static void doDelete() {
        if ((!reverse && start > end) || (reverse && start < end)) {
            isPossible = false;
            return;
        }
        if (reverse) start--;
        else start++;
    }

    private static void doReverse() {
        int temp = start;
        start = end;
        end = temp;
        reverse = reverse ? false : true;
    }

    private static void doSb() {
        if (!isPossible) {
            sb.append("error\n");
            return;
        }
        sb.append("[");
        if (!reverse) {
            for (int i = start; i <= end; i++) {
                if (i == end) {
                    sb.append(arr[i]);
                    break;
                }
                sb.append(arr[i] + ",");
            }
        } else {
            for (int i = start; i >= end ; i--) {
                if (i == end) {
                    sb.append(arr[i]);
                    break;
                }
                sb.append(arr[i] + ",");
            }
        }
        sb.append("]\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            function = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            arr = input.substring(1, input.length() - 1).split(",");

            reverse = false;
            isPossible = true;

            start = 0;
            end = arr.length - 1;

            for (String s : function) {
                switch (s) {
                    case "R" :
                        doReverse();
                        break;
                    case "D" :
                        if (n == 0) {
                            isPossible = false;
                            break;
                        }
                        doDelete();
                        break;
                }
                if (!isPossible) break;
            }
            doSb();
        }
        System.out.println(sb.toString());
    }
}