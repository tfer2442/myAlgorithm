import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLen = 1_000_001;
        
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            if (minLen > right-left+1 && sum == k) {
                minLen = right-left+1;
                answer[0] = left;
                answer[1] = right;
            }
        }
        
        return answer;
    }
}