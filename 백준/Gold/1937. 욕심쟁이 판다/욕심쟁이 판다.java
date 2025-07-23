import java.util.*;
import java.io.*;

/*
 * 1 <= N <= 500
 * 모든 지점에서 완전 탐색을 하면 시간초과
 * DFS + DP
 * 1. [0][0] ~ [n-1][n-1] 지점에서 DFS
 * 2. dp[i][j] 가 0인 지점은 dfs, dp[i][j]가 0이 아니라면, dp[i][j] 값을 반환
 * 3. dfs를 호출한 쪽에서는 dp[i][j] = Math.max(dfs+1, dp[i][j]); 
 */
public class Main {
	public static int N;
	public static int[][] board, dp;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static int dfs(int r, int c) {
		if (dp[r][c] == 0) {
			dp[r][c] = 1;
		}
		
		for (int[] curD : d) {
			int nextR = r + curD[0];
			int nextC = c + curD[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
			if (board[nextR][nextC] <= board[r][c]) continue;
			
			if (dp[nextR][nextC] == 0) {
				dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC)+1);
				continue;
			}
			
			dp[r][c] = Math.max(dp[r][c], dp[nextR][nextC]+1);
		}
		
		return dp[r][c];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] != 0) continue;
				dfs(i, j);
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		
		System.out.println(answer);
	}
}
