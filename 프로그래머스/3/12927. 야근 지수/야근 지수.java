import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            return Integer.compare(o2, o1);
        });
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (!pq.isEmpty() && n > 0) {
            int work = pq.poll();
            n--;
            
            if (work > 1) {
                pq.add(work-1);    
            }
        }
        
        long answer = 0;
        
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}