import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static long M;
	public static long[] dp;
	public static String[] result = new String[] {"M", "e", "s", "s", "i", "Messi Messi Gimossi", "G", "i", "m", "o", "s", "s", "i"};
	
	public static void dac(int N, long index) {
		if (index <= 13) {
			System.out.println(result[(int)index-1]);
			return;
		}
		else if (dp[N-1]+1 == index) {
			System.out.println("Messi Messi Gimossi");
			return;
		} else if (dp[N-1]+1 < index) {
			dac(N-1, index-(dp[N-1]+1));
		} else {
			dac(N-1, index);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Long.parseLong(br.readLine());
		dp = new long[100000];
		dp[1] = 5;
		dp[2] = 13;

		int cur = 0;

		if (M <= 5) {
			cur = 1;
		} else if (M <= 13){
			cur = 2;
		} 
		
		for (int i = 3; i < 100000; i++) {
			dp[i] = dp[i-1] + dp[i-2] + 1;
			if (dp[i] > M) {
				cur = i;
				break;
			}
		} 
		
		dac(cur, M);
	}
}
