import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		//---------여기에 코드를 작성하세요.---------------//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] d = new int[6];
		int [] len = new int[6];
		String check = "42314231";
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < 6; i++) {
			String[] tmp = br.readLine().split(" ");
			d[i] = Integer.parseInt(tmp[0]);
			len[i] = Integer.parseInt(tmp[1]);
		}
		
		
		int updown = 0;
		int lr = 0;
		
		for (int i = 0; i < 6; i++) {
			if (d[i] == 4 || d[i] == 3) {
				updown = Math.max(updown, len[i]);
			}
			
			if (d[i] == 1 || d[i] == 2) {
				lr = Math.max(lr, len[i]);
			}
		}
		int total = updown * lr;
		int result2 = 0;
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			String a = Integer.toString(d[i]) + Integer.toString(d[i+1]);
			if (check.contains(a)) {
				continue;
			} else {
				result2 = len[i] * len[i+1];
				flag = true;
				break;
			}
		}
		
		if (flag) {
			System.out.println((total-result2) * K);
		} else {
			System.out.println((total - len[0] * len[5]) * K);
		}
	}

}
