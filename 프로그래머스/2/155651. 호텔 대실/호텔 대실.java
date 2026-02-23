import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] s = book_time[i][0].split(":");
            int m = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            time[i][0] = m;
            
            s = book_time[i][1].split(":");
            m = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]) + 10;
            time[i][1] = m;
        }
        
        Arrays.sort(time, (o1, o2)-> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });
        
        System.out.println(Arrays.deepToString(time));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            return o1-o2;
        });
        
        int answer = 0;
        
        for (int i = 0; i < time.length; i++) {
            int start = time[i][0];
            
            while (!pq.isEmpty()) {
                int t = pq.peek();
                
                if (t <= start) {
                    pq.poll();
                } else {
                    break;
                }
            }
            
            pq.add(time[i][1]);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}