import java.util.*;

class Solution {
    int[][] board;
    boolean[][] visited;
    int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int N, M;
    
    int bfs(int sr, int sc) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visited[sr][sc] = true;
        dq.add(new int[]{sr, sc});
        
        int sum = board[sr][sc];
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextR = node[0] + d[i][0];
                int nextC = node[1] + d[i][1];
                
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
                if (board[nextR][nextC] == -1) continue;
                if (visited[nextR][nextC]) continue;
                
                sum += board[nextR][nextC];
                visited[nextR][nextC] = true;
                dq.add(new int[]{nextR, nextC});
            }
        }
        
        return sum;
    }
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        ArrayList<Integer> result = new ArrayList<>();
        board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                
                if (c == 'X') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = c - '0';
                }
            }
        }
                
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1) continue;
                if (visited[i][j]) continue;
                result.add(bfs(i, j));
            }
        }
        
        if (result.size() == 0) {
            return new int[] {-1};
        }
        
        result.sort((o1, o2) -> {
            return o1-o2;
        });
        
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}