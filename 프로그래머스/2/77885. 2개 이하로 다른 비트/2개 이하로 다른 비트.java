import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            if (num % 2 == 0) {
                answer[i] = num + 1;
                continue;
            }
            
            long tmp = (num + 1) & ~num;
            num = num + tmp;
            num -= (tmp >> 1);
            
            answer[i] = num;
        }
        
        return answer;
    }
}