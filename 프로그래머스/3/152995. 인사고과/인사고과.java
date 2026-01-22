import java.util.*;


class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wA = scores[0][0];
        int wB = scores[0][1];
        int wTotal = wA + wB;
        
        Arrays.sort(scores, (o1, o2)->{
           if (o1[0] == o2[0]) {
               return Integer.compare(o1[1], o2[1]);
           } 
           
           return Integer.compare(o2[0], o1[0]);
        });
        
        int maxB = 0;
        for (int i = 0; i < scores.length; i++) {
            int curA = scores[i][0];
            int curB = scores[i][1];
            
            if (maxB > curB) {
                if (curA == wA && curB == wB) {
                    return -1;
                }
                continue;
            }
            
            maxB = curB;
            
            if (curA + curB > wTotal) {
                answer++;
            }
        }
        
        return answer;
    }
}