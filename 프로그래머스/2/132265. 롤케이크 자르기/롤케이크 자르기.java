import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            hs.add(topping[i]);
        }
        
        int[] nums = new int[10_001];
        int[] nums2 = new int[10_001];
        int total1 = 0;
        int total2 = hs.size();
        
        for (int i = 0; i < topping.length; i++) {
            nums2[topping[i]]++;
        }
        
        int answer = 0;
        
        for (int i = 0; i < topping.length; i++) {
            int cur = topping[i];
            
            if (nums2[cur] == 1) {
                total2--;
            }
            
            if (nums[cur] == 0) {
                total1++;
            }
            
            nums2[cur]--;
            nums[cur]++;
            
            if (total1 == total2) {
                answer++;
            }
        }
        
        return answer;
    }
}