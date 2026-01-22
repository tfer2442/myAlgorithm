import java.util.*;

class Solution {
    ArrayList<Integer>[] outGraph;
    ArrayList<Integer>[] inGraph;
    HashMap<Integer, Integer> hm;
    boolean[] visited;
    
    public void bfs(int n, int start, ArrayList<Integer>[] graph) {
        visited = new boolean[n+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start] = true;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                dq.add(next);
                hm.put(next, hm.get(next)+1);
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        outGraph = new ArrayList[n+1];
        inGraph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            inGraph[i] = new ArrayList<>();
            outGraph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            
            inGraph[a].add(b);
            outGraph[b].add(a);
        }
        
        hm = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            hm.put(i, 0);
        }
        
        for (int i = 1; i <= n; i++) {
            bfs(n, i, inGraph);
        }
        
        for (int i = 1; i <= n; i++) {
            bfs(n, i, outGraph);
        }
        
        for (int key : hm.keySet()) {
            if (hm.get(key) == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}