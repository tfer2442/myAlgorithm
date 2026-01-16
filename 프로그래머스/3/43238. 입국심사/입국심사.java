import java.util.*;

class Solution {
    long answer = 1_000_000_000_000_000_000L;
        
    public boolean calculate(int n, long mid, int[] times) {
        long cnt = 0;
        long maxValue = 0;
        
        for (int i = 0; i < times.length; i++) {
            long tmp  = mid / times[i];
            maxValue = Math.max(maxValue, tmp * times[i]);
            cnt += tmp;
        }
        
        if (cnt >= n) {
            answer = Math.min(answer, maxValue);
            return true;
        }
        
        return false;
    }
    
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 1_000_000_000_000_000_000L;
        
        Arrays.sort(times);
        
        while (left <= right) {
            long mid = (left + right) / 2;
            boolean flag = calculate(n, mid, times);
            
            if (flag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}