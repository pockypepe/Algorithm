import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Member implements Comparable<Member> {
		int idx;
		int age;
		String name;
		
		public Member(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		// 나이 순 정렬 후 같으면 가입 순
		@Override
		public int compareTo(Member o) {
			if (this.age == o.age) return this.idx - o.idx;
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");
		
		System.out.println(sb.toString());
	}
}