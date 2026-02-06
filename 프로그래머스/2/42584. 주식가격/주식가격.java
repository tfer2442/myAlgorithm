import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            // stack이 비어 있으면 put?
            
            while (!dq.isEmpty()) {
                if (prices[dq.getLast()] > prices[i]) {
                    answer[dq.getLast()] = i - dq.getLast();
                    dq.pollLast();
                } else {
                    break;
                }
            }
            
            dq.addLast(i);
        }
        
        while (!dq.isEmpty()) {
            answer[dq.getLast()] = prices.length - dq.getLast() - 1;
            dq.pollLast();
        }
        
        return answer;
    }
}