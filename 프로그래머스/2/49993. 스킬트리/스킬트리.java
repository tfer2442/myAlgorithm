import java.util.*;

class Solution {
    HashMap<Character, HashSet<Character>> hm;
    
    
    boolean calculate(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) continue;
            
            HashSet<Character> hs = hm.get(s.charAt(i));
            int cnt = 0;
            
            for (int j = 0; j < i; j++) {
                if (hs.contains(s.charAt(j))) {
                    cnt++;
                }
            }
            
            if (cnt < hs.size()) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        hm = new HashMap<>();
        
        for (int i = skill.length()-1; i > 0; i--) {
            char a = skill.charAt(i);
            hm.put(a, new HashSet<>());
            HashSet hs = hm.get(a);
            
            for (int j = 0; j < i; j++) {
                hs.add(skill.charAt(j));
            }
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            if (calculate(skill_trees[i])) {
                answer++;
            }
        }
        
        return answer;
    }
}