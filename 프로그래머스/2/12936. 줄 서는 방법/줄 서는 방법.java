import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        k = k-1;
        int idx = 0;
        
        while (arr.size() > 0) {
            factorial = factorial / n;
            long a = k / factorial;
            k = k % factorial;
            
            answer[idx++] = arr.get((int)a);
            arr.remove((int)a);
            
            n -= 1;    
        }
        
        return answer;
    }
}