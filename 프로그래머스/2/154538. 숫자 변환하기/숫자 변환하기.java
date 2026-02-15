import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {

        boolean[] visited = new boolean[1_000_001];
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, 0});
        visited[x] = true;
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int value = node[0];
            int depth = node[1];
            
            if (value == y) {
                return depth;
            }
            
            if (value + n <= y && !visited[value+n]) {
                visited[value+n] = true;
                dq.add(new int[]{value+n, depth+1});
            }
            
            if (value * 2 <= y && !visited[value*2]) {
                visited[value*2] = true;
                dq.add(new int[]{value*2, depth+1});
            }
            
            if (value * 3 <= y && !visited[value*3]) {
                visited[value*3] = true;
                dq.add(new int[]{value*3, depth+1});
            }
            
        }
        
        return -1;
    }
}