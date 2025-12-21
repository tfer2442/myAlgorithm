import java.util.*;

class Solution {
    HashSet<Integer> hs = new HashSet<>();
    int[][] dp;
    static final int MOD = 1_000_000_007;

    private int key(int r, int c, int m) {
        return r * m + c;
    }

    public int solution(int m, int n, int[][] puddles) {

        for (int i = 0; i < puddles.length; i++) {
            int r = puddles[i][1] - 1;
            int c = puddles[i][0] - 1;
            hs.add(key(r, c, m));
        }

        dp = new int[n][m];

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (hs.contains(key(i, 0, m))) {
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
            if (hs.contains(key(0, i, m))) {
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
                if (hs.contains(key(i, j, m))) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        return dp[n-1][m-1];
    }
}
