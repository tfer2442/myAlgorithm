import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        // stack에 index를 넣기
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            // 맨 위에 있는 인덱스의 값과 들어가고자 하는 인덱스의 값을 비교
            // 만약, 들어가고자 하는게 더 크거나 같다면 or stack이 비어있으면 push
            // 만약, 들어가고자 하는게 더 작다면, top과 계속 비교하면서 pop
            // 이 때, pop 되는 인덱스와 들어가고자 하는 인덱스의 차이를 answer 배열에 저장
            
            if (dq.isEmpty()) {
                dq.addLast(i);
                continue;
            }
            
            int lastIndex = dq.getLast();
            
            if (prices[lastIndex] <= prices[i]) {
                dq.addLast(i);
                continue;
            }
            
            while (true) {
                lastIndex = dq.getLast();
                
                if (prices[lastIndex] > prices[i]) {
                    int idx = dq.pollLast();
                    answer[idx] = i - idx;
                } else {
                    dq.addLast(i);
                    break;
                }
                
                if (dq.isEmpty()) {
                    dq.addLast(i);
                    break;
                }
            }
        }
        
        while (!dq.isEmpty()) {
            int idx = dq.pollLast();
            answer[idx] = N-idx-1;
        } 
                
        return answer;
    }
}
