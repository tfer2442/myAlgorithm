import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            hm2.put(topping[i], hm2.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            int cur = topping[i];
            
            hm1.put(topping[i], hm1.getOrDefault(topping[i], 0) + 1);
            if (hm2.get(topping[i]) == 1) {
                hm2.remove(topping[i]);
            } else {
                hm2.put(topping[i], hm2.get(topping[i]) - 1);
            }
            
            if (hm1.size() == hm2.size()) {
                answer++;
            }
        }
            
        return answer;
    }
}