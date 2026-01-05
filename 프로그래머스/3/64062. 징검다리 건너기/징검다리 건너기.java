import java.util.*;


class Solution {
    public int solution(int[] stones, int k) {
        int answer = 200_000_000;
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < stones.length; i++) {
            
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
            
            if (dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            
            if (i >= k - 1) {
                answer = Math.min(answer, stones[dq.peekFirst()]);
            }
        }
        
        return answer;
    }
}