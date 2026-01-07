import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = N-1; i >= 0; i--) {
            
            while (!dq.isEmpty() && dq.peekLast() <= numbers[i]) {
                dq.pollLast();
            }
            
            if (dq.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = dq.peekLast();
            }
            
            dq.addLast(numbers[i]);
        }
        
        return answer;
    }
}