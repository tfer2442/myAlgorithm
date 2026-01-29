import java.util.*;

class Solution {
    int getMaxValue(int[] arr) {
        int maxValue = 0;
        
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        
        return maxValue;
    }
    
    int solution(int[][] land) {
        int N = land.length;
        int M = 4;
        int answer = 0;
        
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxValue = 0;
                
                for (int k = 0; k < M; k++) {
                    if (j == k) continue;
                    maxValue = Math.max(maxValue, dp[i-1][k]);
                }
                
                dp[i][j] = maxValue + land[i][j];
            }
        }
        
        return getMaxValue(dp[N-1]);
    }
}