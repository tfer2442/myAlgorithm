import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int j = 0;
        boolean flag = false;
        
        for (int i = 0; i <= 1000; i++) {
            
            while (j < citations.length) {
                if (i > citations.length - j) {
                    flag = true;
                    break;
                }
                
                if (i <= citations[j]) {
                    answer = Math.max(answer, i);
                    break;
                } else {
                    j++;
                }
            }
            
            if (flag) break;
        }
        
        return answer;
    }
}