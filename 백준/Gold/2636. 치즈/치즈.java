import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] outside;
    static Map<String, Boolean> cheeze = new HashMap<>();
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        outside = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(outside[i], 1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cheeze.put(i + "," + j, true);
                }
            }
        }

        bfs(0, 0);

        int total = 0;
        int result = cheeze.size();

        while (!cheeze.isEmpty()) {
            total++;
            List<String> tmp = new ArrayList<>();
            for (String ch : cheeze.keySet()) {
                int cnt = 0;
                String[] pos = ch.split(",");
                int row = Integer.parseInt(pos[0]);
                int col = Integer.parseInt(pos[1]);

                for (int[] dir : d) {
                    int nextR = dir[0] + row;
                    int nextC = dir[1] + col;

                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && outside[nextR][nextC] == 0) {
                        cnt++;
                    }
                }

                if (cnt >= 1) {
                    tmp.add(ch);
                }
            }

            for (String t : tmp) {
                String[] pos = t.split(",");
                int row = Integer.parseInt(pos[0]);
                int col = Integer.parseInt(pos[1]);
                bfs(row, col);
            }

            result = cheeze.size();
            for (String t : tmp) {
                cheeze.remove(t);
            }
        }

        System.out.println(total);
        System.out.println(result);
    }

    public static void bfs(int startRow, int startCol) {
        Queue<int[]> dq = new LinkedList<>();
        dq.add(new int[]{startRow, startCol});
        board[startRow][startCol] = 0;
        outside[startRow][startCol] = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : d) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && board[nextRow][nextCol] == 0 && outside[nextRow][nextCol] == 1) {
                    dq.add(new int[]{nextRow, nextCol});
                    outside[nextRow][nextCol] = 0;
                }
            }
        }
    }
}
