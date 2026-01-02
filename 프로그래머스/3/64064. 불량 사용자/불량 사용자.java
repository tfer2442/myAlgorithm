import java.util.*;

class Solution {
    int n, r;
    int answer = 0;
    boolean[] visited;
    boolean flag = false;
    int[] nums;
    String[] combi;
    
    public void permutations(int depth, String[] banned_id) {
        if (depth >= r) {
            
            int count = 0;
            
            for (int i = 0; i < r; i++) {
                int idx = nums[i];
                
                if (combi[idx].length() != banned_id[i].length()) continue;
                
                int count2 = 0;
                
                for (int j = 0; j < combi[idx].length(); j++) {
                    if (combi[idx].charAt(j) == banned_id[i].charAt(j)) {
                        count2++;
                    } else if (banned_id[i].charAt(j) == '*') {
                        count2++;
                    }
                }
                
                if (count2 == combi[idx].length()) {
                    count++;
                }
            }
            
            if (count == r) {
                flag = true;
            }
            
            return;
        }
        
        for (int i = 0; i < r; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            nums[depth] = i;
            permutations(depth+1, banned_id);
            visited[i] = false;
            
            if (flag) {
                return;
            }
            
        }
    }
    
    public void combinations(int depth, int idx, String[] user_id, String[] banned_id) {
        if (depth >= r) {
            permutations(0, banned_id);
            
            if (flag) {
                answer++;
            }
            
            flag = false;
            return;
        }
        
        for (int i = idx; i < n; i++) {
            combi[depth] = user_id[i];
            combinations(depth+1, i+1, user_id, banned_id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        r = banned_id.length;
        
        combi = new String[r];
        visited = new boolean[r];
        nums = new int[r];
        
        combinations(0, 0, user_id, banned_id);
        
        return answer;
    }
}
