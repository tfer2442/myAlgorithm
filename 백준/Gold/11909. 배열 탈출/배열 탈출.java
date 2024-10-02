import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] board, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i][0] = -2000000000;
			board[0][i] = -2000000000;
			
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == 1 && j == 1) continue;
				dp[i][j] = Math.min(dp[i][j-1] + (board[i][j] < board[i][j-1] ? 0 : board[i][j]-board[i][j-1]+1), 
						dp[i-1][j] + (board[i][j] < board[i-1][j] ? 0 : board[i][j]-board[i-1][j]+1));
			}
		}
		System.out.println(dp[N][N]);
	}

}
