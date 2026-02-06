import java.util.*;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int cnt = 0;
        int idx = 0;
    
        for (int i = 0; i < order.length; i++) {
            dq.addLast(i+1);
            
            while (!dq.isEmpty()) {
                if (order[idx] == dq.getLast()) {
                    idx++;
                    dq.pollLast();
                    cnt++;
                } else if (order[idx] < dq.getLast()){
                    return cnt;
                } else {
                    break;
                }
            }
        }
        
        return cnt;
    }
}