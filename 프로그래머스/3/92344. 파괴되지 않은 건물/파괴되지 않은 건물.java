// skill: [type, r1, c1, r2, c2, degree]
// type 1: 공격, type 2: 회복

class Solution {
    int N, M, K;
    int[][] board2;
    
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        K = skill.length;
        
        board2 = new int[N+1][M+1];
        
        for (int i = 0; i < K; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) {
                board2[r1][c1] += (-1) * degree;
                board2[r1][c2+1] += degree;
                board2[r2+1][c1] += degree;
                board2[r2+1][c2+1] += (-1) * degree;
            } else if (type == 2) {
                board2[r1][c1] += degree;
                board2[r1][c2+1] += (-1) * degree;
                board2[r2+1][c1] += (-1) * degree;
                board2[r2+1][c2+1] += degree;
            }
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board2[i][j] += board2[i-1][j];    
            }
        }
        
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board2[j][i] += board2[j][i-1];
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board2[i][j] + board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}