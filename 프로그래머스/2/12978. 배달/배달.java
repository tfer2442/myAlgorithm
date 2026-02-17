import java.util.*;

class Solution {
    ArrayList<int[]>[] graph;
    int[] distance;
    
    void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
            return Integer.compare(o1[1], o2[1]);
        });
        
        Arrays.fill(distance, 1_000_000_000);
        distance[1] = 0;
        
        pq.add(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int v = node[0];
            int value = node[1];
            
            if (value > distance[v]) {
                continue;
            }
            
            for (int i = 0; i < graph[v].size(); i++) {
                int[] nextNode = graph[v].get(i);
                int nextV = nextNode[0];
                int nextValue = value + nextNode[1];
                
                if (nextValue < distance[nextV]) {
                    distance[nextV] = nextValue;
                    pq.add(new int[]{nextV, nextValue});
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList[N+1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int value = road[i][2];
            
            graph[a].add(new int[]{b, value});
            graph[b].add(new int[]{a, value});
        }
        
        distance = new int[N+1];
        
        dijkstra();
        
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}