import java.util.*;

class Solution {
    public HashMap<String, String> hm;
    
    public int solution(String s) {
        hm = new HashMap<>();
        
        hm.put("zero", "0");
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");
        hm.put("seven", "7");
        hm.put("eight", "8");
        hm.put("nine", "9");
        
        for (String tmp : hm.keySet()) {
            s = s.replace(tmp, hm.get(tmp));
        }
        
        return Integer.parseInt(s);
    }
}