import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < N; i++) {
            int num = citations[i];
            
            answer = Math.max(answer, Math.min(N-i, num));
        }
        
        return answer;
    }
}