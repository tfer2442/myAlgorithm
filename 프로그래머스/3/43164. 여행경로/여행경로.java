import java.util.*;

class Solution {
    String[] answer;
    int N;
    HashMap<String, List<String>> hm;
    HashSet<String> hs;
    
    public boolean dfs(int depth, String cur) {
        if (depth == N+1) {
            
            return true;
        }
        
        List<String> next = hm.get(cur);
        
        if (next == null) return false;
        
        for (int i = 0; i < next.size(); i++) {
            if (hs.contains(cur + " " + i)) {
                continue;
            }
            
            answer[depth] = next.get(i);
            hs.add(cur + " " + i);
            
            if (dfs(depth+1, answer[depth])) {
                return true;
            }
            
            hs.remove(cur + " " + i);  
        }
        
        return false;
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length; 
        hm = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            
            if (!hm.containsKey(a)) {
                hm.put(a, new ArrayList<>());
            }
            
            hm.get(a).add(b);
        }
        
        for (String key : hm.keySet()) {
            List<String> l1 = hm.get(key);
            l1.sort((o1, o2)-> {
               return o1.compareTo(o2); 
            });
            
        }
        
        answer = new String[N+1];
        hs = new HashSet<>();
        
        answer[0] = "ICN";
        dfs(1, "ICN");
        
        return answer;
    }
}