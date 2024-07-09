import java.util.*;

public class Solution {
    static class Position {
        int sec, row, col;
        public Position(int sec, int row, int col) {
            this.sec = sec;
            this.row = row;
            this.col = col;
        }
    }

    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};
    static Position start, end;

    public static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, start.row, start.col));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.row == end.row && current.col == end.col) {
                System.out.println(current.sec);
                return;
            }

            if (visited[current.row][current.col]) continue;

            if (board[current.row][current.col] == 2 && current.sec % 3 != 0) {
                queue.add(new Position(current.sec + 1, current.row, current.col));
                continue;
            }

            visited[current.row][current.col] = true;

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dRow[i];
                int nextCol = current.col + dCol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;

                if (!visited[nextRow][nextCol] && board[nextRow][nextCol] != 1) {
                    queue.add(new Position(current.sec + 1, nextRow, nextCol));
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            n = scanner.nextInt();
            board = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }

            start = new Position(0, scanner.nextInt(), scanner.nextInt());
            end = new Position(0, scanner.nextInt(), scanner.nextInt());

            System.out.print("#" + t + " ");
            bfs();
        }
        scanner.close();
    }
}