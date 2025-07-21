import java.util.*;
import java.io.*;

/*
 * 이항 계수를 구하는 문제
 * 1. nCk == nCn-k
 * 2. nCk == n-1Ck-1 + n-1Ck (n > 1, k > 1)
 * 3. nC0 == 1
 */

public class Main {
	public static int N, K;
	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		if (K > N-K) {
			K = N-K;
		}
		
		dp = new int[N+1][K+1];
		
		dp[1][0] = 1;
		
		if (K != 0) {
			dp[1][1] = 1;			
		}
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = 1;
			
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
