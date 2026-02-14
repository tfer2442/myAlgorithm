import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int a = storey % 10;
            int b = storey / 10;
            
            if (a > 5) {
                storey = b + 1;
                answer += 10 - a;
            } else if (a < 5) {
                storey = b;
                answer += a;
            } else {
                if (b % 10 >= 5) {
                    storey = b + 1;
                    answer += 10-a;
                } else {
                    storey = b;
                    answer += a;
                }
            }
        }
        
        return answer;
    }
}