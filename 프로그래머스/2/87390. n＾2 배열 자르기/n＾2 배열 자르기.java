import java.util.*;

/*
실제 2차원 배열을 만들면 터질거같은데
*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for (long i = left; i <= right; i++) {
            long a = i / n;
            long b = i % n;
        
            answer[(int)(i-left)] = (int)Math.max(a, b) + 1;
        }
        
        return answer;
    }
}