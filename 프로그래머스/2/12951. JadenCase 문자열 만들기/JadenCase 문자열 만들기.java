import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arr = s.split(" ", -1);
        
        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i];
            
            if (tmp.length() > 0) {
                answer.append(Character.toUpperCase(tmp.charAt(0)));
                answer.append(tmp.toLowerCase().substring(1));
            }
            
            if (i != arr.length-1) {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}