import java.util.*; 

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int nOneNum = 0;
        String b = Integer.toBinaryString(n);
        
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                nOneNum++;
            }
        }
        
        int cur = n+1;
        
        while (true) {
            String tmp = Integer.toBinaryString(cur);
            int tmpOneNum = 0;
            
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '1') {
                    tmpOneNum++;
                }
            }
            
            if (nOneNum == tmpOneNum) {
                break;
            }
            
            cur++;
        }
        
        return cur;
    }
}