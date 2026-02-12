import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int j = 1;
                
                while (true) {
                    if ((numbers[i] & (1L << j)) == 0) {
                        
                        answer[i] = (numbers[i] - (1L << (j-1))) + (1L << j);
                        break;
                    }
                    
                    j++;
                }
            }
        }
        
        return answer;
    }
}