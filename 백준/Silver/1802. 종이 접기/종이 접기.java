import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static String order;
	public static int N;
	
	public static boolean dac(int s, int e) {
		if (s == e) {
			return true;
		}
		
		int m = (s+e)/2;
		
		for (int i = s; i < m; i++) {
			if (order.charAt(i) == order.charAt(e-i-1)) {
				return false;
			}
		}
		
		return dac(s, m) && dac(m+1, e);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			order = br.readLine();
			N = order.length();
			
			if (dac(0, N)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
