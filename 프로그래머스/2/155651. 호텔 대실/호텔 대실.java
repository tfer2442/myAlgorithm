import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        
        // 끝나는 시간 10분 더해서 보정하기
        int[][] time = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            time[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            time[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
        }
        
        Arrays.sort(time, (o1, o2)-> {
           if (o1[0] == o2[0]) {
               return Integer.compare(o1[1], o2[1]);
           }
            
           return Integer.compare(o1[0], o2[0]);
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
           if (o1[1] == o2[1]) {
               return Integer.compare(o1[0], o2[0]);
           }
            
           return Integer.compare(o1[1], o2[1]);
        });
        
        pq.add(new int[]{time[0][0], time[0][1]});
        int answer = 1;
        
        for (int i = 1; i < time.length; i++) {
            while (!pq.isEmpty()) {
                if (pq.peek()[1] <= time[i][0]) {
                    pq.poll();
                } else {
                    break;
                }
            }
            
            pq.add(new int[]{time[i][0], time[i][1]});
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}