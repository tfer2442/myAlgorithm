import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int j = 1;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < order.length; i++) {
            // order[i]에 있는 값을 찾아야 함. 
            if (order[i] == j) {
                answer++;
                j++;
                continue;
            }
            
            // 만약 order[i] != j 라면, stack or 순서에서 값을 찾아야 함.
            // order[i]와 j의 값을 비교하여, order[i] > j 라면 j++ 해야 함. 그 전에, j를 스택에 넣어야 함.
            while (order[i] > j) {
                dq.addLast(j);
                j++;
            }
            
            if (order[i] == j) {
                answer++;
                j++;
                continue;
            }
            
            if (dq.isEmpty()) break;
            
            if (order[i] == dq.pollLast()) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}