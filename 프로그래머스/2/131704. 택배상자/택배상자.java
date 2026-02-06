import java.util.*;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        // order의 idx를 보면서, 1~N까지 움직이는 반복문도 있어야 함
        
        int cnt = 0;
        int orderIdx = 0;
        int i = 1;
        
        while (orderIdx < order.length) {
            if (order[orderIdx] == i) {
                cnt++;
                orderIdx++;
                i++;
            } else if (!dq.isEmpty() && dq.getLast() == order[orderIdx]) {
                dq.pollLast();
                cnt++;
                orderIdx++;
            } else if (order[orderIdx] > i) {
                dq.addLast(i);
                i++;
            } else if (order[orderIdx] < i) {
                break;
            }
        }
        
        return cnt;
    }
}