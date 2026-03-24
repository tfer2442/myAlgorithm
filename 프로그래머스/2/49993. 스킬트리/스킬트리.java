import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] nums = new int[26];
        
        for (int i = 0; i < skill.length(); i++) {
            nums[skill.charAt(i) - 'A'] = i+1;
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String cur = skill_trees[i];
            int cnt = 1;
            boolean flag = false;
            
            for (int j = 0; j < cur.length(); j++) {
                if (nums[cur.charAt(j)-'A'] == 0) continue;
                
                if (nums[cur.charAt(j)-'A'] != cnt) {
                    flag = true;
                    break;
                }
                cnt++;
            }
            
            if (!flag) {
                answer++;
            }
        }
        
        return answer;
    }
}