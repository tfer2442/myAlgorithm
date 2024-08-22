import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static int T;
    public static int N;
    public static int[][] board;
    public static int[][] dp;
    public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public static class Node {
    	int row;
    	int col;
    	int value;
    	
    	public Node(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
    }

    public static int dfs(int row, int col) {
        dp[row][col] = 0;

        for (int[] dd: d) {
            int nextRow = dd[0] + row;
            int nextCol = dd[1] + col;

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
            if (board[row][col]+1 == board[nextRow][nextCol]) {
                if (dp[nextRow][nextCol] == -1) {
                    dp[row][col] = Math.max(dp[row][col], dfs(nextRow, nextCol));
                } else {
                    dp[row][col] = Math.max(dp[row][col], dp[nextRow][nextCol]+1);
                }
            }
        }

        return dp[row][col]+1;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            dp = new int[N][N];
            Node[] nodes = new Node[N*N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = -1;
                    nodes[i*N+j] = new Node(i, j, board[i][j]);
                }
            }
            
            Arrays.sort(nodes, (o1, o2) -> o1.value - o2.value);
            
            for (int i = 0; i < N*N; i++) {
            	if (dp[nodes[i].row][nodes[i].col] == -1) {
            		dfs(nodes[i].row, nodes[i].col);
            	}
            }

            int answer = -1;
            int answer2 = -1;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                	if (answer < dp[i][j]) {
                		answer = dp[i][j];
                		answer2 = board[i][j];
                		continue;
                	} 
                	if (answer == dp[i][j] && answer2 > board[i][j]) {
                		answer2 = board[i][j];
                	}
                }
            }
            
            System.out.println("#" + t + " " + answer2 + " " + (answer+1));
        }
    }

}