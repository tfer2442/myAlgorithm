import java.util.*;

class Solution {
    int[][] d = {{-1 ,0}, {0, -1}, {0, 1}, {1, 0}};
    int[] start, lever, exit;
    char[][] board;
    
    int bfs(int[] s, int[] e) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        dq.add(new int[]{s[0], s[1], 0});
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            
            if (node[0] == e[0] && node[1] == e[1]) {
                return node[2];
            }
            
            for (int[] dd : d) {
                int nextR = node[0] + dd[0];
                int nextC = node[1] + dd[1];
                
                if (nextR < 0 || nextR >= board.length || nextC < 0 || nextC >= board[0].length) continue;
                if (visited[nextR][nextC]) continue;
                if (board[nextR][nextC] == 'X') continue;
                
                visited[nextR][nextC] = true;
                dq.add(new int[]{nextR, nextC, node[2]+1});
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        start = new int[2];
        lever = new int[2];
        exit = new int[2];
        board = new char[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                board[i][j] = maps[i].charAt(j);
                
                if (board[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (board[i][j] == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        
        int tmp = bfs(start, lever);
        
        if (tmp == -1) {
            return -1;
        }
        
        answer += tmp;
        
        tmp = bfs(lever, exit);
        
        if (tmp == -1) {
            return -1;
        }
        
        answer += tmp;
        
        return answer;
    }
}