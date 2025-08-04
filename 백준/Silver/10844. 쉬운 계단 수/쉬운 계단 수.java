import java.util.*;
import java.io.*;


/*
 * 다시 풀어보기
 * 
 * 주의할 것
 * 1. 10억으로 나눈 나머지를 출력
 */
public class Main {
	public static int N;
	public static long[][] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][10];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            
			for (int j = 1; j <= 8; j++) {
	            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000L;
			}
		}
		
		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer = (answer + dp[N][i]) % 1_000_000_000L;
		}
		
		System.out.println(answer);
	}
}
