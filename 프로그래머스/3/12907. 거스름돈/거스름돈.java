import java.util.*;

class Solution {
    int[][] dp;
        
    public int solution(int n, int[] money) {
        dp = new int[money.length+1][n+1];
        
        Arrays.sort(money);
        
        for (int i = 1; i <= money.length; i++) {
            dp[i][0] = 1;
            
            for (int j = 1; j <= n; j++) {
                if (money[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % 1_000_000_007;
            }
        }
        
        return dp[money.length][n];
    }
}