import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Data implements Comparable<Data> {
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		// x좌표 비교
		@Override
		public int compareTo(Data o) {
			if (this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		List<Data> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Data d = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(d);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");
		
		System.out.println(sb.toString());
		
	}
}