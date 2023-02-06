import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int day = Integer.parseInt(st.nextToken());
		int night = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int count = (height - day);
		if (count % (day - night) == 0) System.out.println(count / (day - night) + 1);
		else System.out.println(count / (day - night) + 2);
	}
}