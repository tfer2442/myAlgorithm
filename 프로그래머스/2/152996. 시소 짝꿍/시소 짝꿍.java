import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++) {
            hm.put(weights[i], hm.getOrDefault(weights[i], 0) + 1);
        }
        
        
        for (int key : hm.keySet()) {
            // 1:1 
            if (hm.get(key) > 1) {
                answer += ((long)hm.get(key) * (hm.get(key)-1)) / 2;
            }
            
            // 1:2
            if ((key * 2) / 1.0 % 1 == 0) {
                int otherKey = (key * 2) / 1;
                answer += (long)hm.get(key) * hm.getOrDefault(otherKey, 0); 
            }
            
            // 2:3
            if ((key * 3) / 2.0 % 1 == 0) {
                int otherKey = (key * 3) / 2;
                answer += (long)hm.get(key) * hm.getOrDefault(otherKey, 0); 
            }
            
            // 3:4
            if ((key * 4) / 3.0 % 1 == 0) {
                int otherKey = (key * 4) / 3;
                answer += (long)hm.get(key) * hm.getOrDefault(otherKey, 0); 
            }
        }
        
        return answer;
    }
}