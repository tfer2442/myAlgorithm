import java.util.*;

class Solution {
    int[] answer;
    boolean[] visited;
    ArrayList<Integer>[] graph;
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Arrays.fill(answer, -1);
        answer[destination] = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        dq.add(destination);
        visited[destination] = true;
        
        while (!dq.isEmpty()) {
            int node = dq.poll();
            
            for (int next : graph[node]) {
                if (visited[next]) continue;
                visited[next] = true;
                answer[next] = answer[node] + 1;
                dq.add(next);
            }
        }
        
        int[] result = new int[sources.length];
        
        for (int i = 0; i < sources.length; i++) {
            result[i] = answer[sources[i]];
        }
        
        return result;
    }
}