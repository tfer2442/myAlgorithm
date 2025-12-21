import java.util.*;

class Solution {
    int[][] dp;
    boolean[][] visited;
    
    public int solution(int m, int n, int[][] puddles) {
        visited = new boolean[n][m];
    
        for (int i = 0; i < puddles.length; i++) {
            visited[puddles[i][1]-1][puddles[i][0]-1] = true;
        }
        
        dp = new int[n][m];
        
        boolean flag = false;
        
        for (int i = 0; i < n; i++) {
            if (visited[i][0]) {
                flag = true;
            }
            
            if (flag) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        
        flag = false;
        
        for (int i = 0; i < m; i++) {
            if (visited[0][i]) {
                flag = true;
            }
            
            if (flag) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (visited[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }

        return dp[n-1][m-1];
    }
}