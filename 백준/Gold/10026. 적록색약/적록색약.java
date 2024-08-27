import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static char[][] visionPeople;
    public static char[][] blindnessPeople;
    public static boolean[][] visited;
    public static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visionPeople = new char[n][n];
        blindnessPeople = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                visionPeople[i][j] = line.charAt(j);
                if (visionPeople[i][j] == 'R' || visionPeople[i][j] == 'G') {
                    blindnessPeople[i][j] = 'G';
                } else if (visionPeople[i][j] == 'B') {
                    blindnessPeople[i][j] = 'B';
                }
            }
        }

        visited = new boolean[n][n];
        int visionCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visionCnt++;
                    bfs(i, j, visionPeople);
                }
            }
        }

        visited = new boolean[n][n];
        int blindnessCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    blindnessCnt++;
                    bfs(i, j, blindnessPeople);
                }
            }
        }

        System.out.println(visionCnt + " " + blindnessCnt);
    }

    public static void bfs(int r, int c, char[][] people) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for (int[] direction : d) {
                int nextR = curR + direction[0];
                int nextC = curC + direction[1];

                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC] && people[r][c] == people[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.add(new int[]{nextR, nextC});
                }
            }
        }
    }
}
