import java.util.*;

class Solution {
    int[] myMinerals;
    int answer = Integer.MAX_VALUE;
    
    void dfs(int idx, int sum, int dia, int iron, int stone) {
        
        if (sum >= answer) {
            return;
        }
        
        if (idx >= myMinerals.length || (dia == 0 && iron == 0 && stone == 0)) {
            answer = sum;
            
            return;
        } 
        
        int nextIdx = Math.min(myMinerals.length, idx+5);
        
        if (dia > 0) {
            int total = 0;
            for (int i = idx; i < nextIdx; i++) {
                total++;
            }
            dfs(nextIdx, sum+total, dia-1, iron, stone);
        }
        
        if (iron > 0) {
            int total = 0;
            for (int i = idx; i < nextIdx; i++) {
                if (myMinerals[i] == 0) {
                    total += 5;
                } else {
                    total += 1;
                }
            }
            
            dfs(nextIdx, sum+total, dia, iron-1, stone);
        }
        
        if (stone > 0) {
            int total = 0;
            for (int i = idx; i < nextIdx; i++) {
                if (myMinerals[i] == 0) {
                    total += 25;
                } else if (myMinerals[i] == 1) {
                    total += 5;
                } else {
                    total += 1;
                }
            }
            
            dfs(nextIdx, sum+total, dia, iron, stone-1);
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        myMinerals = new int[minerals.length];
        
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                myMinerals[i] = 0;
            } else if (minerals[i].equals("iron")) {
                myMinerals[i] = 1;
            } else {
                myMinerals[i] = 2;
            }
        }
        // 광물캐야하는 인덱스, 현재피로도, d곡괭이 수, i곡괭이 수, s곡괭이 수
        dfs(0, 0, picks[0], picks[1], picks[2]);
        return answer;
    }
}