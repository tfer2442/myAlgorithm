import java.util.*;

/*
우선순위 큐
요청 들어온 시간 기록
실제 처리되기 시작한 시간 기록
한 작업이 끝날 때 까지, 다른 작업이 실행되지 않음
*/
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // stable이라서 그런가?
        // 먼저 들어온 시간, 짧은 시간
        Arrays.sort(jobs, (o1, o2)-> {
           if (o1[0] == o2[0]) {
               return Integer.compare(o1[1], o2[1]);
           }
            
           return Integer.compare(o1[0], o2[0]);
        });
        
        
        // [0] : 요청시각, [1] : 소요되는시각
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> { 
           if (o1[1] == o2[1]) {
               return Integer.compare(o1[0], o2[0]);
           }
            
           return Integer.compare(o1[1], o2[1]);
        });
        
        /*
        현재 시간 기준으로 pq에 들어갈 요소들을 넣어둬야한다.
        현재시간은, 점프가 가능하다.
        */
        
        int idx = 0;
        int time = 0;
        int done = 0;

        while (done < jobs.length) {
            while (idx < jobs.length && time >= jobs[idx][0]) {
                pq.add(new int[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            int[] node = pq.poll();
            time = time + node[1];
            answer += (time-node[0]);
            
            done++;
        }
        
        return (int)answer/jobs.length;
    }
}