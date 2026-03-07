import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            int curValue = prices[i];
            
            while (!dq.isEmpty() && prices[dq.getLast()] > curValue) {
                int idx = dq.pollLast();
                answer[idx] = i - idx;
            }
            
            dq.add(i);
        }
        
        while (!dq.isEmpty()) {
            int idx = dq.pollLast();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}