import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int N, M, C;
	public static int[][] board;
	public static int[][] dp;
	public static int r, c;
	public static int total;
	
	public static void calSubSet(int cnt, int sum, int powSum) {
		if (sum > C) {
			return;
		}
		
		if (cnt == M) {
			total = Math.max(total, powSum);
			return;
		}
		
		calSubSet(cnt+1, sum+board[r][c+cnt], powSum+board[r][c+cnt]*board[r][c+cnt]);
		calSubSet(cnt+1, sum, powSum);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-M+1; j++) {
					for (int k = i; k < N; k++) {
						for (int m = 0; m < N-M+1; m++) {
							if (k == i) {
								m += j+M;
								if (m >= N-M+1) break;
							}
							
							r = i;
							c = j;
							total = 0;
							if (dp[i][j] == 0) {
								calSubSet(0, 0, 0);
								dp[i][j] = total;
							}
							
							r = k;
							c = m;
							total = 0;
							
							if (dp[k][m] == 0) {
								calSubSet(0, 0, 0);
								dp[k][m] = total;
							}


							answer = Math.max(answer, dp[i][j]+dp[k][m]);
						}
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
