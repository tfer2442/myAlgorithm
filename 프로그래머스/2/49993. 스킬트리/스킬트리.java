import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skill_idx = new int[26];
        
        for (int i = 1; i <= skill.length(); i++) {
            skill_idx[skill.charAt(i-1) - 'A'] = i;
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i];
            int sum = 1;
            boolean flag = false;
            
            for (int j = 0; j < s.length(); j++) {
                if (skill_idx[s.charAt(j)-'A'] == 0) continue;
                else if (skill_idx[s.charAt(j)-'A'] == sum) {
                    sum++;
                    continue;
                }
                else {
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