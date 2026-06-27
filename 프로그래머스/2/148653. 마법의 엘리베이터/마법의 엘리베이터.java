import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int num = storey;
        
        while (true) {
            if (num == 0) {
                break;
            }
            
            int last = num % 10;
            
            if (last > 5) {
                num = (10 - last) + num;
                answer += (10 - last);
            } else if (last < 5) {
                num = num - last;
                answer += last;
            } else if (last == 5) {
                int cal = num / 10 % 10;
                
                if (cal >= 5) {
                    num = (10 - last) + num;
                    answer += (10 - last);
                } else {
                    num = num - last;
                    answer += last;
                }
            }
            
            num = num / 10;
        }
        
        return answer;
    }
}