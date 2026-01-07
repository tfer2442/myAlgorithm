import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer;
        int N = number.length();
        int[] nums = new int[N];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = N-1; i >= 0; i--) {
            
            while(!dq.isEmpty() && (int)number.charAt(dq.peekLast()) - (int)'0' <= (int)number.charAt(i) - (int)'0') {
                dq.pollLast();
            }
            
            if (dq.isEmpty()) {
                nums[i] = -1;
            } else {
                nums[i] = dq.peekLast();
            }
            
            dq.addLast(i);
        }

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < N; i++) {
            if (nums[i] != -1 && nums[i]-i <= k) {
                visited[i] = true;
                k -= 1;
            }
        }
        
        for (int i = N-1; i >= 0; i--) {
            if (k <= 0) break;
            if (nums[i] == -1) {
                visited[i] = true;
                k -= 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            sb.append(number.charAt(i));
        }
        
        answer = sb.toString();
        return answer;
    }
}