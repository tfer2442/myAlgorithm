import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int[] nums = new int[26];
        Arrays.fill(nums, -1);
        
        for (int i = 0; i < skill.length(); i++) {
            nums[skill.charAt(i) - 'A'] = i; 
        }
        
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String target = skill_trees[i];
            int cnt = 0;
            boolean flag = false;
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                int value = nums[c-'A'];
                
                if (value == -1) {
                    continue;
                } 
                
                if (value == cnt) {
                    cnt++;
                } else {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                answer++;
            }
        }
        
        
        return answer;
    }
}