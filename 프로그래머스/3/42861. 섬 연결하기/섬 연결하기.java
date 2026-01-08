import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        ArrayList<int[]> graph[] = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int value = costs[i][2];
            
            graph[a].add(new int[]{b, value});
            graph[b].add(new int[]{a, value});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
            return Integer.compare(o1[1], o2[1]);
        });
        pq.add(new int[]{0, 0});
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int answer = 0;
        int k = 0;
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int a = node[0];
            int value = node[1];
            
            if (visited[a]) continue;
            
            visited[a] = true;
            answer += value;
            k++;
            
            if (k == n) break;
            
            for (int[] next : graph[a]) {
                int b = next[0];
                int nextValue = next[1];
                
                if (visited[b]) continue;
                pq.add(new int[]{b, nextValue});
            }
        }
        
        return answer;
    }
}