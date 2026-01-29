import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb;
        int cnt = 0;
        int removedZeroCnt = 0;
        
        if (s.length() == 1 && Integer.parseInt(s) == 1) {
            return new int[]{0, 0};
        }
        
        while (true) {
            sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append("1");
                } else {
                    removedZeroCnt++;
                }
            }
            
            cnt++;
            int num = sb.toString().length();
            s = Integer.toBinaryString(num); 
            // s = Integer.parseInt(num, 2) + "";
            
            if (s.length() == 1) break;
        }
        
        return new int[]{cnt, removedZeroCnt};
    }
}