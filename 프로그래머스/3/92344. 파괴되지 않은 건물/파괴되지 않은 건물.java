import java.util.*;

class Solution {
    int[][] skillSum;
    int N, M;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length;
        
        skillSum = new int[N+1][M+1];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) {
                skillSum[r1][c1] += -degree;
                skillSum[r2+1][c1] += degree;
                skillSum[r1][c2+1] += degree;
                skillSum[r2+1][c2+1] += -degree;
            } else if (type == 2) {
                skillSum[r1][c1] += degree;
                skillSum[r2+1][c1] += -degree;
                skillSum[r1][c2+1] += -degree;
                skillSum[r2+1][c2+1] += degree;
            }
        }
        
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                skillSum[i][j] += skillSum[i][j-1];
            }
        }
        
        for (int i = 0; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                skillSum[j][i] += skillSum[j-1][i];
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (skillSum[i][j] + board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}