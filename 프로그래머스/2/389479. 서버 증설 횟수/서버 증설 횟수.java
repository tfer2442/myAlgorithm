import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 1;
        
        // [0] : 유효 증설 시각, [1] : 증설한 서버 수
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 0; i < players.length; i++) {
            if (!dq.isEmpty() && dq.peek()[0] <= i) {
                server -= dq.peek()[1];
                dq.poll();
            }
            
            if (players[i] < server * m) continue;
            
            int num = players[i] - server*m;
            server += num/m + 1;
            
            dq.add(new int[]{i+k, num/m+1});
            answer += num/m+1;
        }
        
        return answer;
    }
}