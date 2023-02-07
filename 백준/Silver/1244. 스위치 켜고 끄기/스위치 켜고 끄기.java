import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine());
		String[] status = br.readLine().split(" ");
		int studentNum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < studentNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int idx = num - 1;
			
			if (gender == 1) {
				while (idx < status.length) {
					onOff(status, idx);
					idx += num;
				}
			} else {
				int a = 1;
				while (idx - a >= 0 && idx + a < status.length) {
					if (status[idx - a].equals(status[idx + a])) {
						onOff(status, idx - a);
						onOff(status, idx + a);
						a++;
					} else break;
				}
				onOff(status, idx);
			}
		}
		for (int i = 0; i < status.length; i++) {
			System.out.print(status[i] + " ");
			if ((i + 1) % 20 == 0) System.out.println();
		}
	}

	private static void onOff(String[] status, int idx) {
		if (status[idx].equals("1")) status[idx] = "0";
		else status[idx] = "1";
	}
}