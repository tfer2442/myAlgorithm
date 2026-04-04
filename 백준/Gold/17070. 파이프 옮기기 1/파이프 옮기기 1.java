import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[][] board;
	public static int[][][] dp;
	
	public static boolean isPossiblePipe(int r, int c, int curD) {
		if (curD == 0) {
			if (c+1 >= N) return false;
			if (board[r][c+1] == 1) return false;
		} else if (curD == 1) {
			if (r+1 >= N) return false;
			if (board[r+1][c] == 1) return false;
			
		} else if (curD == 2) {
			if (r+1 >= N || c+1 >= N) return false;
			if (board[r+1][c] == 1 || board[r][c+1] == 1 || board[r+1][c+1] == 1) return false;
		}
		
		return true;
	}
	
	// 0 : 가로, 1 : 세로, 2 : 대각선
	
	public static int calculate(int r, int c, int prevD) {
		if (r == N-1 && c == N-1) {
			return 1;
		}
		
		if (dp[r][c][prevD] != -1) {
			return dp[r][c][prevD];
		}
		
		dp[r][c][prevD] = 0;
		
		// prevD를 기준으로 놓을 수 있는 파이프를 찾자
		if (prevD == 0) {
			// D 0, 2 가능
			if (isPossiblePipe(r, c, 0)) {
				dp[r][c][prevD] += calculate(r, c+1, 0);
			}
			
			if (isPossiblePipe(r, c, 2)) {
				dp[r][c][prevD] += calculate(r+1, c+1, 2);
			}
			
		} else if (prevD == 1) {
			// D 1, 2 가능			
			if (isPossiblePipe(r, c, 1)) {
				dp[r][c][prevD] += calculate(r+1, c, 1);
			}
			
			if (isPossiblePipe(r, c, 2)) {
				dp[r][c][prevD] += calculate(r+1, c+1, 2);
			}
			
		} else if (prevD == 2) {
			// D 0, 1, 2 다 가능
			
			if (isPossiblePipe(r, c, 0)) {
				dp[r][c][prevD] += calculate(r, c+1, 0);
			}
			
			if (isPossiblePipe(r, c, 1)) {
				dp[r][c][prevD] += calculate(r+1, c, 1);
			}
			
			if (isPossiblePipe(r, c, 2)) {
				dp[r][c][prevD] += calculate(r+1, c+1, 2);		
			}
		}
		
		
		return dp[r][c][prevD];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		dp = new int[N][N][3];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		calculate(0, 1, 0);
		
		System.out.println(dp[0][1][0]);
	}
}
