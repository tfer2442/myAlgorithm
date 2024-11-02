import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] board, dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			
			for (int j = 1; j <= M; j++) {
				board[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] == 0) continue;
				
				dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
				answer = Math.max(answer, dp[i][j]);
			}
		}
		
		System.out.println(answer*answer);
	}
}
