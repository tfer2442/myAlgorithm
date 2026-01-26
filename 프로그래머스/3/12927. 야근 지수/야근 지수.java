import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        while (n > 0) {
            int node = pq.poll();
            
            if (node == 0) break;
            
            pq.add(node-1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            int node = pq.poll();
            answer += (long)node * node;
        }
        
        return answer;
    }
}