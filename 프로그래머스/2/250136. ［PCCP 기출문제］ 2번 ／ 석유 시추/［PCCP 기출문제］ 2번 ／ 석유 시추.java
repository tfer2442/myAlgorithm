import java.util.*;

class Solution {
    int N, M;
    int[][] board;
    int[][] land;
    boolean[][] visited;
    HashMap<Integer, Integer> hm;
    int cnt, cur;
    int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    void dfs(int r, int c) {
        
        for (int i = 0; i < 4; i++) {
            int nextR = r + d[i][0];
            int nextC = c + d[i][1];
            
            if (0 > nextR || nextR >= N || nextC < 0 || nextC >= M) continue;
            if (visited[nextR][nextC] || land[nextR][nextC] == 0) continue;
            
            cnt++;
            board[nextR][nextC] = cur;
            visited[nextR][nextC] = true;
            dfs(nextR, nextC);
        }
    }

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        board = new int[N][M];
        visited = new boolean[N][M];
        hm = new HashMap<>();
        this.land = land;
        
        cur = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                visited[i][j] = true;
                cnt = 1;
                board[i][j] = cur;
                dfs(i, j);
                hm.put(cur++, cnt);
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < M; i++) {
            HashSet<Integer> hs = new HashSet<>();
            
            for (int j = 0; j < N; j++) {
                hs.add(board[j][i]);
            }
            
            int sum = 0;
            for (int key : hs) {
                if (key == 0) continue;
                sum += hm.get(key);
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
}