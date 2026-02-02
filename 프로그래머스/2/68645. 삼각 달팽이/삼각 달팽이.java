import java.util.*;

class Solution {
    public int[] solution(int n) {
        if (n == 1) {
            return new int[] {1};
        }
        
        int K = (n*n-n) / 2 + n;
        int[][] board = new int[n][n];
        
        int[][] d = {{1, 0}, {0, 1}, {-1, -1}};
        int r = -1;
        int c = 0;
        int dir = 0;
        
        for (int i = 1; i <= K; i++) {
            int tmp = dir;

            for (int j = tmp; j < tmp+3; j++) {
                int nextR = r + d[j%3][0];
                int nextC = c + d[j%3][1];
                dir = j%3;
                
                if (nextR >= n || nextC >= n || nextR < 0 || nextC < 0) continue;
                if (board[nextR][nextC] == 0) {
                    board[nextR][nextC] = i;
                    r = nextR;
                    c = nextC;
                    break;
                }
            }
        }
        
        ArrayList<Integer> list1 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) break;
                list1.add(board[i][j]);
            }
        }
        
        int[] answer = new int[list1.size()];
        
        for (int i = 0; i < list1.size(); i++) {
            answer[i] = list1.get(i);
        }
        
        return answer;
    }
}