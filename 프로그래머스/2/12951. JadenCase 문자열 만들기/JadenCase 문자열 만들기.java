import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            String curS = str[i].toLowerCase();
            
            if (curS.equals("")) {
                if (i != str.length-1) {
                    sb.append(" ");
                }
                continue;
            }
            
            char c = curS.charAt(0);
            
            if (c >= 'a' && c <= 'z') {
                c = (char)(c + ('A' - 'a'));
            }
            
            sb.append(c);
            
            if (curS.length() >= 2) {
                sb.append(curS.substring(1));
            }
            
            if (i != str.length-1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}