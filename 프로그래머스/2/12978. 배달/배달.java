import java.util.*;

/*
시작점이 정해져있는 최단거리 문제 -> 다익스트라로 해결 가능
*/
class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N+1];
        
        Arrays.fill(distance, 1_000_000_000);
        distance[1] = 0;
        
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int[] tmp = road[i];
            int a = tmp[0];
            int b = tmp[1];
            int value = tmp[2];
            
            graph[a].add(new int[]{b, value});
            graph[b].add(new int[]{a, value});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o1[1]-o2[1]; 
        });
        
        
        pq.add(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            
            if (node[1] < distance[node[0]]) continue;
            
            for (int[] next : graph[node[0]]) {
                int v = next[0];
                int value = next[1] + distance[node[0]];
                
                if (distance[v] > value) {
                    distance[v] = value;
                    pq.add(new int[]{v, value});
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) answer++;
        }

        return answer;
    }
}