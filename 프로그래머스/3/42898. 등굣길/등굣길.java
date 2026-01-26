import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < puddles.length; i++) {
            int[] puddle = puddles[i];
            int a = puddle[0]-1;
            int b = puddle[1]-1;
            
            board[b][a] = -1;
        }
        
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (board[i][0] == -1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        
        for (int i = 1; i < m; i++) {
            if (board[0][i] == -1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == -1) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }
        
        return dp[n-1][m-1];
    }
}