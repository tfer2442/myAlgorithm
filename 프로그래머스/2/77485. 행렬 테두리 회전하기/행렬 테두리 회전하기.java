import java.util.*;

class Solution {
    int[][] board;
    int N, M;
    
    int rotateEdge(int r1, int c1, int r2, int c2) {
        int tmp = board[r1][c1];
        int minValue = tmp;
        
        for (int i = r1; i < r2; i++) {
            board[i][c1] = board[i+1][c1];
            minValue = Math.min(minValue, board[i][c1]);
        }
        
        for (int i = c1; i < c2; i++) {
            board[r2][i] = board[r2][i+1];
            minValue = Math.min(minValue, board[r2][i]);
        }
        
        for (int i = r2; i > r1; i--) {
            board[i][c2] = board[i-1][c2];
            minValue = Math.min(minValue, board[i][c2]);
        }
        
        for (int i = c2; i > c1; i--) {
            board[r1][i] = board[r1][i-1];
            minValue = Math.min(minValue, board[r1][i]);
        }
        
        board[r1][c1+1] = tmp;
        
        return minValue;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        N = rows;
        M = columns;
        
        int[] answer = new int[queries.length];
        board = new int[N][M];
        
        int value = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = value++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < queries.length; i++) {
            answer[idx++] = rotateEdge(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
    
        return answer;
    }
}