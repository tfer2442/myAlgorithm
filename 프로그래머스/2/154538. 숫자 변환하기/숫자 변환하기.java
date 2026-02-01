import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y+1];
        
        // [0] : depth, [1] : 현재 x
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        dq.add(new int[]{0, x});
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            
            if (node[1] > y) continue;
            if (visited[node[1]]) continue;
            visited[node[1]] = true;
            
            if (node[1] == y) {
                return node[0];
            }
            
            dq.add(new int[]{node[0]+1, node[1]+n});
            dq.add(new int[]{node[0]+1, node[1]*2});
            dq.add(new int[]{node[0]+1, node[1]*3});
        }
                
        return -1;
    }
}