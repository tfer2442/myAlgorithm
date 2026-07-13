import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        // 현재 시간에 필요한 서버 수 : players[i] / m
        
        for (int i = 0; i < 24; i++) {
            if (servers[i] <= players[i] / m) {
                int add = players[i] / m - servers[i];
                answer += add;
                
                for (int j = 0; j < k; j++) {
                    if (i+j >= 24) break;
                    servers[i+j] += add;
                }
            }
        }
        
        return answer;
    }
}