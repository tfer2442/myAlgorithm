import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int a = n % 3;
            
            if (a == 0) {
                sb.append("4");
                n = (n / 3) - 1;
            } else {
                sb.append(a);
                n = n / 3;
            }
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}