import java.util.*;

class Solution {
    int N, M;
    int[][] board;
    int[][] land;
    HashMap<Integer, Integer> hm;
    int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    void bfs(int sr, int sc, int cnt) {
        int size = 1;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        board[sr][sc] = cnt;
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            
            for (int[] dd : d) {
                int nextR = node[0] + dd[0];
                int nextC = node[1] + dd[1];
                
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
                if (land[nextR][nextC] == 0) continue;
                if (board[nextR][nextC] != 0) continue;
                
                board[nextR][nextC] = cnt;
                dq.add(new int[]{nextR, nextC});
                size++;
            }
        }
        
        hm.put(cnt, size);
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        board = new int[N][M];
        this.land = land;
        
        int cnt = 1;
        hm = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && board[i][j] == 0) {
                    bfs(i, j, cnt);
                    cnt++;

                }
            }
        }
        
        int answer = 0;
        HashSet<Integer> hs;
        
        for (int j = 0; j < M; j++) {
            hs = new HashSet<>();
            int curSize = 0;
            
            for (int i = 0; i < N; i++) {
                if (board[i][j] == 0) continue;
                hs.add(board[i][j]);
            }
            
            for (int tmp : hs) {
                curSize += hm.get(tmp);
            }
            
            answer = Math.max(answer, curSize);
        }
        
        return answer;
    }
}