import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[][] board;
	public static long[][][] dp;
	public static int N;
	public static int[][] d = {{0, 1}, {1, 1}, {1, 0}};
	
	public static long dfs(int cRow, int cCol,int cD) {
		if (cRow == N-1 && cCol == N-1) {
			return 1;
		}
		
		if (dp[cRow][cCol][cD] != -1) return dp[cRow][cCol][cD];
		dp[cRow][cCol][cD] = 0;
		
		for (int i = 0; i < 3; i++) {
			if (cD == 0 && i == 2) continue;
			if (cD == 2 && i == 0) continue;
			int nRow = cRow + d[i][0];
			int nCol = cCol + d[i][1];
			
			if (0 > nRow || nRow >= N || 0 > nCol || nCol >= N) continue;
			if (board[nRow][nCol]==1) continue;
			if (i==1 && (board[nRow-1][nCol]==1 || board[nRow][nCol-1]==1)) continue;

			if (dp[nRow][nCol][i] == -1) {
				dp[cRow][cCol][cD] += dfs(nRow, nCol, i);
			} else {
				dp[cRow][cCol][cD] += dp[nRow][nCol][i];
			}
		}
		
		return dp[cRow][cCol][cD];
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new long[N][N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 0; k < N; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		dfs(0, 1, 0);
		long total = 0;
		for (int i = 0; i < 3; i++) {
			if (dp[0][1][i] != -1) {
				total += dp[0][1][i];
			}
		}
		System.out.println(total);
		
		
	}

}