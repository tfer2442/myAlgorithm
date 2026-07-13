import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    HashMap<String, Integer> hm;
    
    /* 곡괭이 선택하고, cur부터 cur+4까지 광물을 캠
    곡괭이는 값이 있는 것 중 랜덤 선택.
    모든 경우를 봐야하므로 곡괭이는 다시 돌려놔야 함
    */
    public void dfs(int[] picks, String[] minerals, int cur, int sum) {
        if (sum >= answer) return;
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = sum;
            return;
        }
        if (minerals.length <= cur) {
            answer = sum;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            int tmp = 0;
            
            for (int j = 0; j < 5; j++) {
                if (cur + j >= minerals.length) break;
                int next = cur+j;
                int value = hm.get(minerals[next]);
                
                if (i <= value) {
                    tmp += 1;
                } else if (i == value+1) {
                    tmp += 5;
                } else if (i == value+2) {
                    tmp += 25;
                }
                
            }
            dfs(picks, minerals, cur+5, sum+tmp);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        hm = new HashMap<>();
        
        hm.put("diamond", 0);
        hm.put("iron", 1);
        hm.put("stone", 2);
        
        dfs(picks, minerals, 0, 0);
        
        return answer;
    }
}