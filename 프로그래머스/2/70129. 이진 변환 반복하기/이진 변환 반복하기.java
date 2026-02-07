import java.util.*;

class Solution {
    int cvt = 0;
    int zero = 0;
    
    int countOne(String s) {
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                zero++;
            }
        }
        
        return cnt;
    }
    
    public int[] solution(String s) {
        if (s.length() == 1 && Integer.parseInt(s) == 1) return new int[]{0, 0};
        
        int[] answer = {};
                
        while (true) {   
            int cnt = countOne(s);
            s = Integer.toBinaryString(cnt);
            cvt++;
            
            if (s.length() == 1 && Integer.parseInt(s) == 1) break;
        }
        
        return new int[]{cvt, zero};
    }
}