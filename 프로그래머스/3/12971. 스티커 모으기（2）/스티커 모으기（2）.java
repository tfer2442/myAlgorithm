import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        Arrays.fill(dp1, 0);
        Arrays.fill(dp2, 0);
        
        dp1[0] = sticker[0];
        
        for (int i = 1; i < N-1; i++) {
            if (i >= 2) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);        
            } else {
                dp1[i] = Math.max(dp1[i-1], sticker[i]);        
            }
        }
        
        if (N > 1) {
            dp1[N-1] = dp1[N-2];
        }
                
        dp2[0] = 0;
        for (int i = 1; i < N; i++) {
            if (i >= 2) {
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            } else {
                dp2[i] = Math.max(dp2[i-1], sticker[i]);
            }
        }

        return Math.max(dp1[N-1], dp2[N-1]);
    }
}
