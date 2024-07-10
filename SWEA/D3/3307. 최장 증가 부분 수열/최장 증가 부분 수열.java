import java.util.*;
import java.lang.*;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
         
        int T = scanner.nextInt();
         
        for (int t = 1; t <= T; t++) {           
            int N = scanner.nextInt();
            int[] board = new int[N];
             
            for (int i = 0; i < N; i++) {
                board[i] = scanner.nextInt();
            }
             
            int[] dp = new int[N];
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (board[i] > board[j]) {
                        if (dp[j] >= dp[i]) {
                            dp[i] = dp[j] + 1;
                        }
                    }
                }
            }
             
            int maxValue = -1;
             
            for (int i = 0; i < N; i++) {
                maxValue = Math.max(maxValue, dp[i]);
            }
             
            System.out.println("#" + t + " " + (maxValue+1));
        }
    }
}