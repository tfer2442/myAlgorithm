import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int idx = 0;
        
        for (int i = 0; i < order.length; i++) {
            dq.addLast(i+1);
            
            while (!dq.isEmpty()) {
                if (dq.getLast() == order[idx]) {
                    idx++;
                    answer++;
                    dq.pollLast();
                } else if (dq.getLast() > order[idx]) {
                    return answer;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}