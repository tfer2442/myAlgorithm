import java.util.*;

class Solution {
    
//     String calculate(int num) {
//         Integer.binaryToString(num);
//     }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder(s);
        int zeroCnt = 0;
        int changeNum = 0;
 
        while (true) {
            if (s.toString().equals("1")) {
                break;
            }
            
            int tmp =  0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                } else {
                    tmp++;
                }
            }
            
            s = Integer.toBinaryString(tmp);
            
            changeNum++;
        }
        
        answer[0] = changeNum;
        answer[1] = zeroCnt;
        
        return answer;
    }
}