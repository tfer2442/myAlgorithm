import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static long k;
	public static boolean flag = true;
	
	public static void dac(long n, long curK) {
		if (n == 1) {
			return;
		}
		
		if (n/2 < curK) {
			flag = !flag;
			dac(n/2, curK-n/2);
		} else {
			dac(n/2, curK);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Long.parseLong(br.readLine());
		
		long prev = 0;
		long cur = 1;
		while (true) {
			if (prev < k && k <= cur) break;
			prev = cur;
			cur *= 2;
		}
		
		dac(cur, k);
		if (flag) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}

}
