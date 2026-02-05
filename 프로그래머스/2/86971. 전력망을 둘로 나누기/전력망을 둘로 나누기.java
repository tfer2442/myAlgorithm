import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<Integer>[] tree;
    int answer = Integer.MAX_VALUE;
    int total = 0;
    
    void dfs(int excludeA, int excludeB, int cur) {        
        for (int next : tree[cur]) {
            if (next == excludeA && cur == excludeB) continue;
            if (next == excludeB && cur == excludeA) continue;
            if (visited[next]) continue;
            
            visited[next] = true;
            total++;
            dfs(excludeA, excludeB, next);
        }
    }
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n+1];
            visited[1] = true;
            total++;
            
            dfs(wires[i][0], wires[i][1], 1);
            
            answer = Math.min(answer, Math.abs(n-total - total));
            total = 0;
        }
        
        return answer;
    }
}