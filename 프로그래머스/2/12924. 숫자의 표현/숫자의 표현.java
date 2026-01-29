import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        
        int left = 1;
        for (int right = 1; right <= n; right++) {
            sum += right;   
            
            if (sum == n) {
                answer++;
                continue;
            }
            
            if (sum > n) {
                for (; left <= right; left++) {
                    if (sum == n) {
                        answer++;
                        break;
                    }
                    
                    if (sum < n) break;
                    
                    sum -= left;
                }
            }
        }
        
        return answer;
    }
}