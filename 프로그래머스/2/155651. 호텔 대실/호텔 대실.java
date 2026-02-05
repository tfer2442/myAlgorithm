import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] time = new int[1451];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 9;
            
            time[s] += 1;
            time[e+1] += -1;
        }
        
        int answer = 0;
        
        for (int i = 1; i <= 1450; i++) {
            time[i] += time[i-1];
            answer = Math.max(answer, time[i]);
        }
        
        return answer;
    }
}