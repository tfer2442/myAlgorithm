import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ");
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            maxValue = Math.max(maxValue, Integer.parseInt(words[i]));
            minValue = Math.min(minValue, Integer.parseInt(words[i]));
        }  
        
        return minValue + " " + maxValue;
    }
}