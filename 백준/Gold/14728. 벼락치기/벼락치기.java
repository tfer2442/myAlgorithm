import java.util.*;
import java.io.*;

public class Main {
	public static int N, T;
	public static int[][] scores;
	public static int[][] dp;
	public static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		scores = new int[N+1][2];
		dp = new int[N+1][T+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			scores[i+1] = new int[] {k, s};
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= T; j++) {
				if (scores[i][0] > j) {
					dp[i][j] = dp[i-1][j];
					continue;
				} 
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-scores[i][0]] + scores[i][1]); 
			}
		}
		
		System.out.println(dp[N][T]);
	}

}
