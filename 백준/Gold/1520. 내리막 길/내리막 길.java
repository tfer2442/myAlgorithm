import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[][] dp;
    static int n, m;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  // DP 배열 초기화
            }
        }

        System.out.println(backtracking(0, 0));
    }

    static int backtracking(int curRow, int curCol) {
        if (curRow == n - 1 && curCol == m - 1) {
            return 1;
        }

        if (dp[curRow][curCol] == -1) {
            dp[curRow][curCol] = 0;

            for (int[] dir : d) {
                int nextRow = curRow + dir[0];
                int nextCol = curCol + dir[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && board[curRow][curCol] > board[nextRow][nextCol]) {
                    if (dp[nextRow][nextCol] == -1) {
                        dp[curRow][curCol] += backtracking(nextRow, nextCol);
                    } else {
                        dp[curRow][curCol] += dp[nextRow][nextCol];
                    }
                }
            }
        }

        return dp[curRow][curCol];
    }
}
