import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static long X;
	public static long[] dp;
	
	public static long dac(int curN, long curX) {
		if (curN >= curX) {
			return 0;
		}
		
		if (curN == 0 && curX == 0) {
			return 0;
		} else if (curN == 0 && curX == 1) {
			return 1;
		}
		
		long prev = 1;
		long total = 1;
		
		for (int i = 1; i <= curN; i++) {
			total = 2 + (prev*2) + 1;
			prev = total;
		}
		
		long answer = 0;
		
		if (curX < total/2) {
			answer = dac(curN-1, curX-1);
		} else if (curX == total/2) {
			answer = dp[curN-1];
		} else if (curX == total/2+1) {
			answer = dp[curN-1]+1;
		} else if (curX > total/2+1 && curX <= total-curN){
			answer = dp[curN-1] + 1 + dac(curN-1, curX-(total/2+1));
		} else if (curX > total-curN) {
			answer = dp[curN-1]*2 + 1;
		}

		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		dp = new long[N+1];
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1]*2+1;
		}
		
		System.out.println(dac(N, X));
	}

}
