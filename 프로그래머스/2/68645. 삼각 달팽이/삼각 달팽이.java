import java.util.*;

class Solution {
    int[][] d = {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int N = (n*n + n) / 2;
        int[] answer = new int[N];
        int[][] board = new int[n][n];
        int dir = 0;
        int r = 0;
        int c = 0;
        
        for (int i = 0; i < N; i++) {
            
            board[r][c] = i+1;

            if (r + d[dir][0] < 0 || r + d[dir][0] >= n || c + d[dir][1] < 0 || c + d[dir][1] >= n || board[r + d[dir][0]][c + d[dir][1]] != 0) {
                dir = (dir + 1) % 3;
            }
            
            r += d[dir][0];
            c += d[dir][1];
        }
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    answer[idx] = board[i][j];
                    idx++;
                } 
            }
        }
        
        return answer;
    }
}