import java.util.*;
import java.io.*;

/*
 * 1 <= N, M <= 500 (일반적인 완전탐색으로는 시간초과)
 * dfs + dp 를 이용
 * 1. 이미 가봤던 경우에 대해서는 계산되어 있던 dp 값을 이용
 * 2. dp[nextR][nextC]가 0일 때는 dp[r][c] += dfs(nextR, nextC);
 * 3. 아니라면 dp[r][c] += dp[nextR][nextC];
 * 4. 아. 그런데, 이미 가봤는데 도착하는 경우가 없어서 0인 경우도 dp[nextR][nextC] == 0 일텐데,
 * 5. 그러면 dp를 -1로 초기화 해두자.
 */

public class Main {
	public static int N, M;
	public static int[][] board, dp;
	public static int[][] d = {{0, 1}, {1, 0}, {-1 ,0}, {0, -1}};
	
	public static int dfs(int r, int c) {
		dp[r][c] = 0;
		
		for (int[] curD : d) {
			int nextR = r + curD[0];
			int nextC = c + curD[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
			if (board[r][c] <= board[nextR][nextC]) continue;
						
			if (dp[nextR][nextC] == -1) {
				dp[r][c] += dfs(nextR, nextC);
				continue;
			}
			
			dp[r][c] += dp[nextR][nextC];
		}
		
		return dp[r][c];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		dp[N-1][M-1] = 1;
		dfs(0, 0);
		System.out.println(dp[0][0]);
	}
}
