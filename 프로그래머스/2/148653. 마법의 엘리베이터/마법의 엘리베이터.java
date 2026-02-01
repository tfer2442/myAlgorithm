import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int last = storey % 10;
            int next = storey / 10 % 10;
            
            if (last > 5 || (last == 5 && next >= 5)) {
                answer += (10-last);
                storey = storey / 10 + 1;
            } else {
                answer += last;
                storey = storey / 10;
            }
        }
        
        return answer;
    }
}