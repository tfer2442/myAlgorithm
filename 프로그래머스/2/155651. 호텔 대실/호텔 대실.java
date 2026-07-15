import java.util.*;

/*
0. 최소 회의실 개수와 유사한 문제
1. 시각을 모두 분으로 변환
2. 우선순위 큐, 끝나는 시간을 기준으로 정렬되도록 세팅
3. 큐에 add 할 때, 큐에서 뺄 수 있는 시간은 while문으로 빼기

*/
class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            bookTime[i] = new int[]{s, e};
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            
            return Integer.compare(o1[1], o2[1]);
        });
        
        int answer = 0;
        
        Arrays.sort(bookTime, (o1, o2) -> Integer.compare(o1[0], o2[0]));


        for (int i = 0; i < bookTime.length; i++) {
            int start = bookTime[i][0];
            int end = bookTime[i][1];
            
            while (true) {                
                if (!pq.isEmpty() && (pq.peek()[1]+10 <= start)) {
                    pq.poll();
                } else {
                    pq.add(new int[]{start, end});
                    answer = Math.max(answer, pq.size());
                    break;
                }
            }

        }
        
        return answer;
    }
}