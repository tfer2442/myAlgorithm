import java.util.*;
import java.io.*;
/*
 * 정해진 카드 갯수를 최대한 비싼 돈으로 사야하는 문제
 * 구매 갯수: 1 <= N <= 1,000, 금액 1 <= P <= 10,000
 * dp 문제. 이전에 구했던 카드팩 1~N개를 갖기 위해 사용했던 금액을 가지고, 
 * 현재 카드팩을 구매하면 더 비싸게 살 수 있는지 확인해야 함.
 */

public class Main {
	public static int N;
	public static int[] p;
	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		dp = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i-1][j];
			}
			
			for (int j = i; j <= N; j++) {
				if (dp[i-1][j] > dp[i][j-i] + p[i]) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i][j-i] + p[i];
				}
			}
		}
		
		System.out.println(dp[N][N]);
	}
}
