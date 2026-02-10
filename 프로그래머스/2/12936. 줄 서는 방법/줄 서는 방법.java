import java.util.*;

class Solution {
    long factorial(int n) {
        long tmp = 1;
        
        for (int i = 1; i <= n; i++) {
            tmp = tmp * i;
        }
        
        return tmp;
    }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        LinkedList<Integer> chain = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            chain.add(i);
        }
        
        k -= 1;
        int cnt = 0;
        int N = n;
                
        while (cnt < N) {
            long value = factorial(n)/n;
            long idx = k/value;
            answer[cnt++] = chain.get((int)idx);
            chain.remove((int)idx);
            n -= 1;
            k = k%value;
        }
        
        return answer;
    }
}