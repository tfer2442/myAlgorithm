import java.util.*;

class Solution {
    int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    int bfs(int[] start, int[] end, String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        visited[start[0]][start[1]] = true;
        dq.add(new int[]{start[0], start[1], 0});
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextR = node[0] + d[i][0];
                int nextC = node[1] + d[i][1];
                
                if (nextR < 0 || nextR >= maps.length || nextC < 0 || nextC >= maps[0].length()) continue;
                
                if (visited[nextR][nextC] || maps[nextR].charAt(nextC) == 'X') continue;
                
                if (nextR == end[0] && nextC == end[1]) {
                    return node[2] + 1;
                }
                
                visited[nextR][nextC] = true;
                dq.add(new int[]{nextR, nextC, node[2]+1});
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            String line = maps[i];
            
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (line.charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (line.charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        int leverDistance = bfs(start, lever, maps);
        
        if (leverDistance == -1) {
            return -1;
        }
        
        int endDistance = bfs(lever, end, maps);
        
        if (endDistance == -1) {
            return -1;
        }
  
        return leverDistance + endDistance;
    }
}