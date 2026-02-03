import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int left = 0;
        int sum = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            if (o1[1]-o1[0] == o2[1]-o2[0]) {
                return Integer.compare(o1[0], o2[0]); 
            }
            
            return Integer.compare(o1[1]-o1[0], o2[1]-o2[0]);
        });
        
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            if (sum == k) {
                pq.add(new int[]{left, right});
            } else if (sum > k) {
                while (left <= right) {
                    sum -= sequence[left];
                    left++;

                    if (sum == k) {
                        pq.add(new int[]{left, right});
                        break;
                    } else if (sum < k) {
                        break;
                    }
                }
            }            
        }
        
        return pq.poll();
    }
}