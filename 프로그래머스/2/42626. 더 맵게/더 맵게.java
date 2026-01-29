import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            return Integer.compare(o1, o2);
        });
        
        int cnt = 0;
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (!pq.isEmpty()) {
            // pq의 꼭대기 값이 K이상이라면 횟수 return
            if (pq.peek() >= K) {
                return cnt;
            } 
            
            // 꼭대기 값이 K미만이면서, 1개 밖에 원소가 안남았다면 -1 return
            if (pq.size() == 1) {
                return -1;
            }
            
            // 원소가 2개이상 남았다면, 섞어서 넣기
            int a = pq.poll();
            int b = pq.poll(); 
            
            pq.add(a+(b*2));
            cnt++;
        }
        
        return 0;
    }
}