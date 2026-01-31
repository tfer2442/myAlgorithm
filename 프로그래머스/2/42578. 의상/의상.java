import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        
        int value = 1;
        
        for (String key : hm.keySet()) {
            value *= (hm.get(key)+1); 
        }
        
        return value-1;
    }
}