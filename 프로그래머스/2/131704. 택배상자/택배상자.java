import java.util.*;

/*
보조 컨베이어 벨트 stack

현재 가지고 있는 상자를 컨베이어 벨트에 넣을지 말지 결정 해야겠다.

*/
class Solution {
    public int solution(int[] order) {
        
        int box = 0;
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < order.length; i++) {
            boolean flag = false;
            
            while (true) {
                if (!dq.isEmpty() && dq.getLast() == order[i]) {
                    answer++;
                    dq.pollLast();
                    break;
                }
                
                box++;
                
                if (box > order.length) {
                    flag = true;
                    break;
                }
                
                dq.addLast(box);                
            }
            
            if (flag) break;
        }     
        
        return answer;
    }
}