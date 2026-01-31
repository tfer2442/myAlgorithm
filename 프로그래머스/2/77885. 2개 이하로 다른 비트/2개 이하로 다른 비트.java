import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i] + 1;
            long diff = numbers[i] ^ x;
            long value = x + (diff >> 2);
            
            answer[i] = value;
        }
        
        
        return answer;
    }
}