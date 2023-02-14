import java.io.*;
import java.util.*;

public class Main {
	static class Word implements Comparable<Word>{
		int len;
		String word;
		
		public Word(int len, String word) {
			this.len = len;
			this.word = word;
		}
		// 길이 순 정렬 후 사전식 정렬
		@Override
		public int compareTo(Word o) {
			if (this.len == o.len) return this.word.compareTo(o.word);
			return this.len - o.len;
		}
		// set에 add하기 전 같은 객체인지 판단
		@Override
		public boolean equals(Object o) {
			if (o instanceof Word) {
				Word temp = (Word) o;
				return len == temp.len && word.equals(temp.word);
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(len, word);
		}
		
		@Override
		public String toString() {
			return word;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Set<Word> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			set.add(new Word(word.length(), word));
		}
		List<Word> list = new ArrayList<>(set);

		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");
		
		System.out.println(sb.toString());
	}
}
