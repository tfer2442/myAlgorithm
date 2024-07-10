import java.util.*;
import java.lang.*;
 

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
         
        int T = scanner.nextInt();
         
        for (int t = 1; t <= T; t++) {           
            int N = scanner.nextInt();
            int L = scanner.nextInt();
             
            int[][] bag = new int[N][2];
             
            for (int j = 0; j < N; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                 
                bag[j][0] = a;
                bag[j][1] = b;
            }
             
            int[][] board = new int[N+1][L+1];
             
            for (int j = 0; j <= L; j++) {
                board[0][j] = 0;
            }
             
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <= L; k++) {
                    if (bag[j][1] > k) {
                        board[j+1][k] = board[j][k];
                        continue;
                    }
                     
                    if (board[j][k] >= bag[j][0] + board[j][k-bag[j][1]]) {
                        board[j+1][k] = board[j][k];
                    } else {
                        board[j+1][k] = bag[j][0] + board[j][k-bag[j][1]];
                    }
                }
            }
             
            System.out.println("#" + t + " " + board[N][L]);
        }
    }
}