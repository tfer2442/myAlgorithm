import java.util.*;
import java.io.*;

/*
 * 동전의 종류가 주어지고, target 금액을 만들 수 있는 경우의 수
 * 동전 가지 수 1 <= N <= 20, 금액 1 <= M <= 10,000
 * 동전의 종류별로 1원 ~ target 금액까지 만들 수 있는 경우의 수를 구한다
 * 동전의 종류가 추가됨에 따라서 1~target 금액까지 만들 수 있는 경우의 수를 구해나간다.
 * dp[i][j] = dp[i-1][j] + dp[i][j-현재동전값] 
 */
public class Main {
	public static int T, N, M;
	public static int[] coins;
	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			dp = new int[N+1][M+1];
			
			for (int i = 1; i <= N; i++) {
				int range = Math.min(coins[i], M+1);
				
				for (int j = 1; j < range; j++) {
					dp[i][j] = dp[i-1][j];
				}
				
				if (coins[i] > M) continue;
				
				dp[i][coins[i]] = dp[i-1][coins[i]] + 1;
				
				for (int j = coins[i]+1; j <= M; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}
