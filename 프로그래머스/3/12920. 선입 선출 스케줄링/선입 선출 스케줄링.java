import java.util.*;

class Solution {
    
    long calculate(int[] cores, int time) {
        long sum = 0;
        
        for (int i = 0; i < cores.length; i++) {
            sum += time/cores[i] + 1L;
        }
        
        return sum;
    }
    
    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }
        
        int left = 0;
        int right = 10_000 * 50_000;
        int time = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long value = calculate(cores, mid);
            
            if (value >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        long endJob = calculate(cores, time-1);
        
        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                endJob++;
            }
            
            if (endJob == n) {
                return i+1;
            }
        }
        
        return 0;
    }
}