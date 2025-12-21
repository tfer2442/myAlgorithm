import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (n > 0) {
            int a = pq.poll();
            
            if (a == 0) return 0;
            
            pq.add(a-1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            int value = pq.poll();
            
            answer += value * value; 
        }
        
        return answer;
    }
}