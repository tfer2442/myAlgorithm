import java.util.*;


class Solution {
    int[][] dp;
    
    public int solution(int[][] triangle) {
        int h = triangle.length;
        dp = new int[h][h];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
                
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        int answer = 0;
        
        for (int i = 0; i < h; i++) {
            answer = Math.max(answer, dp[h-1][i]);
        }
        
        return answer;
    }
}